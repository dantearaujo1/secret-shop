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
import com.smd.umake.services.BranchService;
import com.smd.umake.services.ProductService;

@RestController
@RequestMapping("/api/v1/branch")
public class BranchController{

  @Autowired
  private BranchService branchService;
  @Autowired
  private ProductService productService;
  @Autowired
  private ProductService productService;

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
    Branch cli = branchService.createBranch(newBranch);
    if (cli == null){
      throw new Exception();
    } else {
      return new ResponseEntity<Branch>(cli, HttpStatus.CREATED);
    }

  }
  @PostMapping("/add/product")
  public ResponseEntity<Branch> addProduct(@RequestBody ObjectNode  json) throws Exception{
    String branchId = json.get("branchId").asText();
    String productId = json.get("productId").asText();

    // INFO: Aparentemente n preciso criar os objetos ja que tenho
    // os ids
    Branch branch = branchService.getBranchById(branchId);
    Product product = productService.getProductById(productId);
    // branch.getStock().getProductadd(product);
    // if (cli == null){
    //   throw new Exception();
    // } else {
    //   return new ResponseEntity<Branch>(cli, HttpStatus.CREATED);
    // }
    return null;
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
