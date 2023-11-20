package com.smd.umake.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smd.umake.dtos.SaleDTO;
import com.smd.umake.entities.Branch;
import com.smd.umake.entities.Client;
import com.smd.umake.entities.Sale;
import com.smd.umake.entities.Seller;
import com.smd.umake.repositories.BranchRepository;
import com.smd.umake.repositories.ClientRepository;
import com.smd.umake.repositories.SaleRepository;
import com.smd.umake.repositories.SellerRepository;

@Service
public class SaleService {

  @Autowired
  private SaleRepository saleRepository;
  @Autowired
  private SellerRepository sellerRepository;
  @Autowired
  private BranchRepository branchRepository;
  @Autowired
  private ClientRepository clientRepository;

  public Sale getSaleById(String id) throws Exception {
    // TODO: checar string vazia
    UUID ID = UUID.fromString(id);
    Optional<Sale> sale = saleRepository.findById(ID);
    if (sale.isPresent()){
      return sale.get();
    } else{
      throw new Exception("Não foi encontrado nenhuma venda com esse id!");
    }

  }
  public List<Sale> getSales() throws Exception {
    List<Sale> sales = saleRepository.findAll();
    return sales;
  }
  public List<Sale> getSalesBySeller(String sellerId) throws Exception {
    try{
      UUID id = UUID.fromString(sellerId);
      List<Sale> sales = saleRepository.findAllBySeller(id);
      return sales;
    } catch (IllegalArgumentException e) {
      throw new Exception("Não é um id válido!");
    }
  }
  public List<Sale> getSalesByClient(String clientId) throws Exception {
    try{
      UUID id = UUID.fromString(clientId);
      List<Sale> sales = saleRepository.findAllByClient(id);
      return sales;
    } catch (IllegalArgumentException e) {
      throw new Exception("Não é um id válido!");
    }
  }
  public List<Sale> getSalesByBranch(String branchId) throws Exception {
    try{
      UUID id = UUID.fromString(branchId);
      List<Sale> sales = saleRepository.findAllByBranch(id);
      return sales;
    } catch (IllegalArgumentException e) {
      throw new Exception("Não é um id válido!");
    }
  }

  public Sale createSale(SaleDTO newSale) throws Exception {
    Sale sale = new Sale();

    // WARN: Handle UUID being not valid
    Optional<Seller> seller = sellerRepository.findById(UUID.fromString(newSale.getSeller()));
    Optional<Client> client = clientRepository.findById(UUID.fromString(newSale.getClient()));
    Optional<Branch> branch = branchRepository.findById(UUID.fromString(newSale.getBranch()));

    if (seller.isPresent()){
      sale.setSeller(seller.get());
    } else {
      throw new Exception("Vendedor não encontrado");
    }
    if (branch.isPresent()){
      sale.setBranch(branch.get());
    } else {
      throw new Exception("Filial não encontrada");
    }
    if (client.isPresent()){
      sale.setClient(client.get());
    } else {
      throw new Exception("Cliente não encontrado");
    }

    sale.setTotal(newSale.getTotal());

    Sale dSale = saleRepository.save(sale);
    return dSale;
  }

}
