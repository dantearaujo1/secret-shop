package com.smd.umake.services;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smd.umake.entities.Branch;
import com.smd.umake.entities.Product;
import com.smd.umake.entities.Stock;
import com.smd.umake.entities.StockKey;
import com.smd.umake.repositories.BranchRepository;
import com.smd.umake.repositories.ProductRepository;
import com.smd.umake.repositories.StockRepository;

@Service
public class StockService {

  @Autowired
  private StockRepository stockRepository;
  @Autowired
  private ProductRepository productRepository;
  @Autowired
  private BranchRepository branchRepository;

  public List<Product> getProducts(String branchID) throws Exception {
    try{
      UUID id = UUID.fromString(branchID);
      List<Stock> stocks = stockRepository.findAllByBranchId(id);
      return stocks.stream().map(Stock::getProduct).collect(Collectors.toList());

    } catch (IllegalArgumentException e){
      return null;
    }
  }
  public List<Branch> getBranchs(String productID) throws Exception {
    try{
      UUID id = UUID.fromString(productID);
      List<Stock> stocks = stockRepository.findAllByProductId(id);
      return stocks.stream().map(Stock::getBranch).collect(Collectors.toList());
    } catch (IllegalArgumentException e){
      return null;
    }
  }
  public Stock addProduct(String branchID, String productID, int quantity) throws Exception {
    try{
      UUID bID = UUID.fromString(branchID);
      UUID pID = UUID.fromString(productID);
      Optional<Branch> b = branchRepository.findById(bID);
      Branch branch = b.orElseThrow( () -> new Exception("Filial não encontrada") );
      Optional<Product> p = productRepository.findById(pID);
      Product product = p.orElseThrow( () -> new Exception("Produto não encontrado") );

      StockKey stockID = new StockKey(bID,pID);

      Optional<Stock> s = stockRepository.findById(stockID);
      Stock stock = s.orElse( new Stock(stockID, branch, product, 0) );

      int currentQuantity = stock.getQuantity();
      stock.setQuantity(currentQuantity + quantity);
      return stockRepository.save(stock);

    } catch (IllegalArgumentException e){
      throw new Exception("Erro adicionando produto!");
    }
  }
  public Set<Product> addProducts(String branchID, Set<String> productID) throws Exception {
    // TODO: Implement this
    return null;
  }

  public void removeProduct(String branchID, String productID, int quantity) throws Exception {
    try{
      UUID bID = UUID.fromString(branchID);
      UUID pID = UUID.fromString(productID);
      Optional<Branch> b = branchRepository.findById(bID);
      Branch branch = b.orElseThrow( () -> new Exception("Filial não encontrada") );
      Optional<Product> p = productRepository.findById(bID);
      Product product = p.orElseThrow( () -> new Exception("Produto não encontrado") );

      StockKey stockID = new StockKey(bID,pID);

      Optional<Stock> s = stockRepository.findById(stockID);
      Stock stock = s.orElseThrow( () -> new Exception("Não tem este produto nesta filial!") );

      int currentQuantity = stock.getQuantity();
      stock.setQuantity(currentQuantity - quantity);
      stockRepository.save(stock);

    } catch (IllegalArgumentException e){
      throw new Exception("Erro adicionando produto!");
    }
  }
  public String removeProducts(String stockID, List<String> productID) throws Exception {
    // TODO: Implement this
    // try{
    //   UUID id = UUID.fromString(stockID);
    //   Optional<Stock> oStock = stockRepository.findById(id);
    //     if (oStock.isPresent()){
    //       stockRepository.delete(oStock.get());
    //       return "Stock deleted!";
    //     } else {
    //       return "Could't delete the stock with this id!";
    //     }
    //
    // } catch (IllegalArgumentException e){
    //   throw new Exception("There was a problem with the delete operation!");
    // }
    return null;
  }
  public void clearStock(String branchID) throws Exception {
    try{
      UUID id = UUID.fromString(branchID);
      List<Stock> entries = stockRepository.findAllByBranchId(id);
      for (Stock entry : entries){
        stockRepository.delete(entry);
      }
    } catch (IllegalArgumentException e){
      throw new Exception("Foi passado um id incorreto");
    }

  }


}
