package com.smd.umake.controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smd.umake.entities.Sale;
import com.smd.umake.services.SaleService;

@RestController
@RequestMapping("/api/v1/sell")
public class SaleController{

  @Autowired
  private SaleService saleService;

  @GetMapping("/{id}")
  public ResponseEntity<Sale> getSaleById(@PathVariable String id) throws Exception {
    Sale p = saleService.getSaleById(id);
    if (p == null){
      throw new Exception();
    } else {
      return new ResponseEntity<> (p,HttpStatus.OK);
    }
  }
  @GetMapping("")
  public ResponseEntity<List<Sale>> getSales() throws Exception {
    List<Sale> p = saleService.getSales();
    if (p == null){
      throw new Exception();
    } else {
      return new ResponseEntity<> (p,HttpStatus.OK);
    }
  }
  // @DeleteMapping("/{id}")
  // public ResponseEntity<String> deleteSaleById(@PathVariable UUID id) throws Exception {
  //   String result = saleService.deleteSale(id);
  //   return new ResponseEntity<String>(result,HttpStatus.OK);
  // }
  // @PostMapping("/")
  // public ResponseEntity<Sale> addSale(@RequestBody SaleDTO  newSale) throws Exception{
  //   Sale prod = saleService.createSale(newSale);
  //   if (prod == null){
  //     throw new Exception();
  //   } else {
  //     return new ResponseEntity<Sale>(prod, HttpStatus.CREATED);
  //   }
  //
  // }
  // @PatchMapping("/{id}")
  // public ResponseEntity<Sale> updatePartialSaleById(@PathVariable UUID id, @RequestBody SaleDTO updatedData) throws Exception {
  //   Sale prod = saleService.updatePartialSale(id, updatedData);
  //   if (prod == null){
  //     throw new Exception();
  //   } else {
  //     return new ResponseEntity<Sale>(prod, HttpStatus.CREATED);
  //   }
  // }

}
