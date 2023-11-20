package com.smd.umake.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.smd.umake.dtos.BranchDTO;
import com.smd.umake.entities.Branch;
import com.smd.umake.entities.Product;
import com.smd.umake.entities.Stock;
import com.smd.umake.services.BranchService;
import com.smd.umake.services.ProductService;
import com.smd.umake.services.StockService;

@RestController
@RequestMapping("/api/v1/branch")
public class BranchController{

  @Autowired
  private BranchService branchService;
  @Autowired
  private ProductService productService;
  @Autowired
  private StockService stockService;

  @GetMapping("/{id}")
  public ResponseEntity<Branch> getBranchById(@PathVariable String id) throws Exception {
    Branch p = branchService.getBranchById(id);
    if (p == null){
      // WARN: Aqui a gente devia enviar uma resposta com o status correto
      // de falha, no caso :)!
      throw new Exception("Não encontramos o branche!");
    } else {
      return new ResponseEntity<> (p,HttpStatus.OK);
    }
  }
  @GetMapping("/")
  public ResponseEntity<Branch> getBranchByName(@RequestParam("name") String name) throws Exception {
    Branch p = branchService.getBranchByName(name);
    if (p == null){
      throw new Exception();
    } else {
      return new ResponseEntity<> (p,HttpStatus.OK);
    }
  }
  @GetMapping("/{id}/stock")
  public ResponseEntity<List<Product>> getProductsFromBranch(@PathVariable String id) throws Exception {
    List<Product> products = stockService.getProducts(id);
    return new ResponseEntity<> (products,HttpStatus.OK);
  }
  @GetMapping("")
  public ResponseEntity<List<Branch>> getBranchs() throws Exception {
    List<Branch> p = branchService.getBranchs();
    if (p == null){
      throw new Exception();
    } else {
      return new ResponseEntity<> (p,HttpStatus.OK);
    }
  }
  @DeleteMapping("/{id}")
  public ResponseEntity<String> deleteBranchById(@PathVariable String id) throws Exception {
    String result = branchService.deleteBranch(id);
    return new ResponseEntity<String>(result,HttpStatus.OK);
  }
  @PostMapping("/")
  public ResponseEntity<Branch> addBranch(@RequestBody BranchDTO  newBranch) throws Exception{
    Branch bra = branchService.createBranch(newBranch);
    if (bra == null){
      throw new Exception();
    } else {
      return new ResponseEntity<Branch>(bra, HttpStatus.CREATED);
    }

  }
  @PostMapping("/add/product")
  public ResponseEntity<Stock> addProduct(@RequestBody ObjectNode  json) throws Exception{
    String branchId = json.get("branchId").asText();
    String productId = json.get("productId").asText();
    int quantity = json.get("quantity").asInt();

    Branch branch = branchService.getBranchById(branchId);
    Product product = productService.getProductById(productId);
    Stock entry = stockService.addProduct(branchId,productId,quantity);
    if (entry == null){
      throw new Exception();
    } else {
      return new ResponseEntity<Stock>(entry, HttpStatus.CREATED);
    }
  }
  // @PatchMapping("/{id}")
  // public ResponseEntity<Branch> updatePartialBranchById(@PathVariable UUID id, @RequestBody BranchDTO updatedData) throws Exception {
  //   Branch prod = saleService.updatePartialBranch(id, updatedData);
  //   if (prod == null){
  //     throw new Exception();
  //   } else {
  //     return new ResponseEntity<Branch>(prod, HttpStatus.CREATED);
  //   }
  // }

}
