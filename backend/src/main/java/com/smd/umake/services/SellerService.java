package com.smd.umake.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smd.umake.dtos.SellerDTO;
import com.smd.umake.entities.Seller;
import com.smd.umake.repositories.SellerRepository;

@Service
public class SellerService {

  @Autowired
  private SellerRepository sellerRepository;

  public List<Seller> getSellers() throws Exception {
    List<Seller> sellers = sellerRepository.findAll();
    return sellers;
  }
  public Seller getSellerById(String sellerId) throws Exception {
    try{
      UUID id = UUID.fromString(sellerId);
      Optional<Seller> seller = sellerRepository.findById(id);
      if(seller.isPresent()){
        return seller.get();
      }
      return null;
    } catch (IllegalArgumentException e){
      return null;
    }
  }
  public Seller getSellerByName(String name) throws Exception {
    Optional<Seller> oSeller = sellerRepository.findDistinctByName(name);
    if (oSeller.isPresent()){
      return oSeller.get();
    }
    return null;
  }
  public Seller createSeller(SellerDTO newSeller) throws Exception {
    Seller seller = new Seller();
    seller.setName(newSeller.getName());
    return sellerRepository.save(seller);
  }

  public String deleteSeller(String sellerID) throws Exception {
    try{
      UUID id = UUID.fromString(sellerID);
      Optional<Seller> oSeller = sellerRepository.findById(id);
        if (oSeller.isPresent()){
          sellerRepository.delete(oSeller.get());
          return "Seller deleted!";
        } else {
          return "Could't delete the seller with this id!";
        }

    } catch (IllegalArgumentException e){
      throw new Exception("There was a problem with the delete operation!");
    }
  }

}
