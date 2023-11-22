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

import com.smd.umake.dtos.SellerDTO;
import com.smd.umake.entities.Seller;
import com.smd.umake.services.SellerService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/v1/seller")
@Tag(name="Vendedor")
public class SellerController{

  @Autowired
  private SellerService sellerService;

  @Operation(summary="Retorna um Vendedor pelo ID", method="GET")
  @ApiResponses( value = {
    @ApiResponse(responseCode = "200", description="Vendedor encontrado e retornado com sucesso"),
    @ApiResponse(responseCode = "404", description="Vendedor não encontrado"),
    @ApiResponse(responseCode = "400", description="Parâmetros inválidos"),
  } )
  @GetMapping("/{id}")
  public ResponseEntity<Seller> getSellerById(@PathVariable String id) throws Exception {
    Seller p = sellerService.getSellerById(id);
    if (p == null){
      // WARN: Aqui a gente devia enviar uma resposta com o status correto
      // de falha, no caso :)!
      throw new Exception("Não encontramos o sellere!");
    } else {
      return new ResponseEntity<> (p,HttpStatus.OK);
    }
  }
  @Operation(summary="Retorna um Vendedor pelo Nome", method="GET")
  @ApiResponses( value = {
    @ApiResponse(responseCode = "200", description="Vendedor encontrado e retornado com sucesso"),
    @ApiResponse(responseCode = "404", description="Vendedor não encontrado"),
    @ApiResponse(responseCode = "400", description="Parâmetros inválidos"),
  } )
  @GetMapping("/")
  public ResponseEntity<Seller> getSellerByName(@RequestParam("name") String name) throws Exception {
    Seller p = sellerService.getSellerByName(name);
    if (p == null){
      throw new Exception();
    } else {
      return new ResponseEntity<> (p,HttpStatus.OK);
    }
  }
  @Operation(summary="Retorna uma lista com todos os vendedores", method="GET")
  @ApiResponses( value = {
    @ApiResponse(responseCode = "200", description="Vendedores encontrados e retornados com sucesso"),
    @ApiResponse(responseCode = "400", description="Parâmetros inválidos"),
  } )
  @GetMapping("")
  public ResponseEntity<List<Seller>> getSellers() throws Exception {
    List<Seller> p = sellerService.getSellers();
    if (p == null){
      throw new Exception();
    } else {
      return new ResponseEntity<> (p,HttpStatus.OK);
    }
  }
  @Operation(summary="Deleta um Vendedor pelo ID", method="DELETE")
  @ApiResponses( value = {
    @ApiResponse(responseCode = "200", description="Vendedor deletado com sucesso"),
    @ApiResponse(responseCode = "404", description="Vendedor não encontrado"),
    @ApiResponse(responseCode = "400", description="Parâmetros inválidos"),
  } )
  @DeleteMapping("/{id}")
  public ResponseEntity<String> deleteSellerById(@PathVariable String id) throws Exception {
    String result = sellerService.deleteSeller(id);
    return new ResponseEntity<String>(result,HttpStatus.OK);
  }
  @Operation(summary="Cria um Vendedor", method="POST")
  @ApiResponses( value = {
    @ApiResponse(responseCode = "200", description="Vendedor criado com sucesso"),
    @ApiResponse(responseCode = "400", description="Parâmetros inválidos"),
  } )
  @PostMapping("/")
  public ResponseEntity<Seller> addSeller(@RequestBody SellerDTO  newSeller) throws Exception{
    Seller cli = sellerService.createSeller(newSeller);
    if (cli == null){
      throw new Exception();
    } else {
      return new ResponseEntity<Seller>(cli, HttpStatus.CREATED);
    }

  }
  // @PatchMapping("/{id}")
  // public ResponseEntity<Seller> updatePartialSellerById(@PathVariable UUID id, @RequestBody SellerDTO updatedData) throws Exception {
  //   Seller prod = saleService.updatePartialSeller(id, updatedData);
  //   if (prod == null){
  //     throw new Exception();
  //   } else {
  //     return new ResponseEntity<Seller>(prod, HttpStatus.CREATED);
  //   }
  // }

}
