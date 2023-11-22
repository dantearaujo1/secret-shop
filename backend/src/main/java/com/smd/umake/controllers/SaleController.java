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
import org.springframework.web.bind.annotation.RestController;

import com.smd.umake.dtos.SaleDTO;
import com.smd.umake.entities.Sale;
import com.smd.umake.services.SaleService;

@RestController
@RequestMapping("/api/v1/sell")
public class SaleController{

  @Autowired
  private SaleService saleService;

  @GetMapping("/{id}")
  public ResponseEntity<?> getSaleById(@PathVariable String id) throws Exception {
    Sale p = saleService.getSaleById(id);
    if (p == null){
      // TODO: Usar entity not found Exception
      throw new Exception();
    } else {
      return new ResponseEntity<Sale> (p,HttpStatus.OK);
    }
  }
  @GetMapping("/branch/{id}")
  public ResponseEntity<?> getSalesByBranch(@PathVariable String id) throws Exception {
    List<Sale> p = saleService.getSalesByBranch(id);
    if (p == null){
      // TODO: Usar entity not found Exception
      throw new Exception();
    } else {
      return new ResponseEntity<List<Sale>> (p,HttpStatus.OK);
    }
  }
  @GetMapping("/client/{id}")
  public ResponseEntity<?> getSalesByClient(@PathVariable String id) throws Exception {
    List<Sale> p = saleService.getSalesByClient(id);
    if (p == null){
      // TODO: Usar entity not found Exception
      throw new Exception();
    } else {
      return new ResponseEntity<List<Sale>> (p,HttpStatus.OK);
    }
  }
  @GetMapping("/seller/{id}")
  public ResponseEntity<?> getSalesBySeller(@PathVariable String id) throws Exception {
    List<Sale> p = saleService.getSalesBySeller(id);
    if (p == null){
      // TODO: Usar entity not found Exception
      throw new Exception();
    } else {
      return new ResponseEntity<List<Sale>> (p,HttpStatus.OK);
    }
  }
  @GetMapping("")
  public ResponseEntity<?> getSales() throws Exception {
    List<Sale> p = saleService.getSales();
    if (p == null){
      // TODO: Usar entity not found Exception
      throw new Exception();
    } else {
      return new ResponseEntity<List<Sale>> (p,HttpStatus.OK);
    }
  }
  @DeleteMapping("/{id}")
  public ResponseEntity<String> deleteSaleById(@PathVariable String id) throws Exception {
    // TODO: Isso n deve retornar uma string pois assim sempre vamos enviar OK
    // mesmo com erro
    String result = saleService.deleteSale(id);
    return new ResponseEntity<String>(result,HttpStatus.OK);
  }
  @PostMapping("/")
  public ResponseEntity<?> addSale(@RequestBody SaleDTO  newSale) throws Exception{
    Sale sale = saleService.createSale(newSale);
    if (sale == null){
      return new ResponseEntity<String>("Could not create the sale!", HttpStatus.BAD_REQUEST);
    } else {
      return new ResponseEntity<Sale>(sale, HttpStatus.CREATED);
    }

  }
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
