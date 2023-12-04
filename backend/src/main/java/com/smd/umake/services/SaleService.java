package com.smd.umake.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smd.umake.dtos.ProductSaleDTO;
import com.smd.umake.dtos.SaleDTO;
import com.smd.umake.entities.Branch;
import com.smd.umake.entities.Client;
import com.smd.umake.entities.Product;
import com.smd.umake.entities.Sale;
import com.smd.umake.entities.SaleProduct;
import com.smd.umake.entities.SaleProductKey;
import com.smd.umake.entities.Seller;
import com.smd.umake.exceptions.ArgumentInvalidException;
import com.smd.umake.exceptions.EntityNotFoundException;
import com.smd.umake.repositories.BranchRepository;
import com.smd.umake.repositories.ClientRepository;
import com.smd.umake.repositories.ProductRepository;
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
  @Autowired
  private ProductRepository productRepository;

  public Sale getSaleById(String id) throws Exception {
    // TODO: checar string vazia
    try{
      UUID ID = UUID.fromString(id);
      Optional<Sale> sale = saleRepository.findById(ID);
      if (sale.isPresent()){
        return sale.get();
      } else{
        throw new EntityNotFoundException("Não foi encontrado nenhuma venda com esse id!");
      }
    } catch (IllegalArgumentException e){
      throw new ArgumentInvalidException("Id não é válido!");
    }

  }
  public List<Sale> getSales() throws Exception {
    List<Sale> sales = saleRepository.findAll();
    return sales;
  }
  public List<Sale> getSalesBySeller(String sellerId) throws Exception {
    try{
      UUID id = UUID.fromString(sellerId);
      Optional<Seller> seller = sellerRepository.findById(id);
      if (seller.isPresent()){
        List<Sale> sales = saleRepository.findAllBySeller(seller.get());
        return sales;
      }
      throw new EntityNotFoundException("Não foi encontrado nenhum Vendedor.");
    } catch (IllegalArgumentException e) {
      throw new ArgumentInvalidException("Foi passado um id inválido");
    }
  }
  public List<Sale> getSalesByClient(String clientId) throws Exception {
    try{
      UUID id = UUID.fromString(clientId);
      Optional<Client> cli = clientRepository.findById(id);
      if (cli.isPresent()){
        List<Sale> sales = saleRepository.findAllByClient(cli.get());
        return sales;
      }
      throw new EntityNotFoundException("Não foi encontrado nenhum Cliente.");
    } catch (IllegalArgumentException e) {
      throw new ArgumentInvalidException("Foi passado um id inválido");
    }
  }
  public List<Sale> getSalesByBranch(String branchId) throws Exception {
    try{
      UUID id = UUID.fromString(branchId);
      Optional<Branch> branch = branchRepository.findById(id);
      if (branch.isPresent()){
        List<Sale> sales = saleRepository.findAllByBranch(branch.get());
        return sales;
      }
      throw new EntityNotFoundException("Não foi encontrado nenhuma Filial.");
    } catch (IllegalArgumentException e) {
      throw new ArgumentInvalidException("Foi passado um id inválido");
    }
  }

  public Sale createSale(SaleDTO newSale) throws Exception {
      Sale sale = new Sale();

      try{

      Optional<Seller> seller = sellerRepository.findById(UUID.fromString(newSale.getSeller()));
      Optional<Client> client = clientRepository.findById(UUID.fromString(newSale.getClient()));
      Optional<Branch> branch = branchRepository.findById(UUID.fromString(newSale.getBranch()));

      if (seller.isPresent()){
        sale.setSeller(seller.get());
      } else {
        throw new EntityNotFoundException("Vendedor não encontrado");
      }
      if (branch.isPresent()){
        sale.setBranch(branch.get());
      } else {
        throw new EntityNotFoundException("Filial não encontrada");
      }
      if (client.isPresent()){
        sale.setClient(client.get());
      } else {
        throw new EntityNotFoundException("Cliente não encontrado");
      }

      List<SaleProduct> products = new ArrayList<SaleProduct>();

      for (ProductSaleDTO var : newSale.getSale_products()) {
        UUID id = UUID.fromString(var.getProductID());
        int quantity = var.getQuantity();
        Optional<Product> oP = productRepository.findById(id);
        if(oP.isPresent()){
          Product p = oP.get();
          SaleProductKey key = new SaleProductKey(sale.getId(), p.getId());
          SaleProduct sp = new SaleProduct(key,p,sale,quantity);
          products.add(sp);

        }
      }
      sale.setSale_products(products);
      sale.setTotal(newSale.getTotal());

      Sale dSale = saleRepository.save(sale);
      return dSale;
    } catch (IllegalArgumentException e){
      throw new ArgumentInvalidException("Foi passado um id inválido");
    }
  }

  public String deleteSale(String saleID) throws Exception {
    try{
      UUID id = UUID.fromString(saleID);
      Optional<Sale> sale = saleRepository.findById(id);
      if (sale.isPresent()){
        saleRepository.delete(sale.get());
        return "Sale deleted!";
      }
      return "Sale not found!";
    } catch (IllegalArgumentException e) {
      throw new ArgumentInvalidException("Foi passado um id inválido");
    }
  }

}
