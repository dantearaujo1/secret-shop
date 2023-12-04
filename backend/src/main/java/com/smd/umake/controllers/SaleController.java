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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/v1/sell")
@Tag(name="Vendas")
public class SaleController{

  @Autowired
  private SaleService saleService;

  @Operation(summary="Retorna Venda pelo ID da venda", method="GET")
  @ApiResponses( value = {
    @ApiResponse(responseCode = "200", description="Venda encontrada com sucesso"),
    @ApiResponse(responseCode = "404", description="Venda não encontrada"),
    @ApiResponse(responseCode = "400", description="Parâmetros inválidos"),
  } )
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
  @Operation(summary="Retorna vendas de uma filial especifica pelo ID da filial", method="GET")
  @ApiResponses( value = {
    @ApiResponse(responseCode = "200", description="Vendas encontradas com sucesso"),
    @ApiResponse(responseCode = "404", description="Filial não encontrada"),
    @ApiResponse(responseCode = "400", description="Parâmetros inválidos"),
  } )
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
  @Operation(summary="Retorna as vendas para um Cliente com base no ID dele", method="GET")
  @ApiResponses( value = {
    @ApiResponse(responseCode = "200", description="Vendas retornadas com sucesso"),
    @ApiResponse(responseCode = "404", description="Cliente não encontrado"),
    @ApiResponse(responseCode = "400", description="Parâmetros inválidos"),
  } )
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
  @Operation(summary="Retorna as vendas de um vendedor com base no ID dele", method="GET")
  @ApiResponses( value = {
    @ApiResponse(responseCode = "200", description="Vendas retornadas com sucesso"),
    @ApiResponse(responseCode = "404", description="Vendedor não encontrado"),
    @ApiResponse(responseCode = "400", description="Parâmetros inválidos"),
  } )
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

  @Operation(summary="Retorna todas as vendas", method="GET")
  @ApiResponses( value = {
    @ApiResponse(responseCode = "200", description="Vendas retornadas com sucesso"),
    @ApiResponse(responseCode = "400", description="Parâmetros inválidos"),
  } )
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

  @Operation(summary="Deleta uma venda com base no ID", method="DELETE")
  @ApiResponses( value = {
    @ApiResponse(responseCode = "200", description="Venda deletada com sucesso"),
    @ApiResponse(responseCode = "404", description="Venda não encontrada"),
    @ApiResponse(responseCode = "400", description="Parâmetros inválidos"),
  } )
  @DeleteMapping("/{id}")
  public ResponseEntity<String> deleteSaleById(@PathVariable String id) throws Exception {
    // TODO: Isso n deve retornar uma string pois assim sempre vamos enviar OK
    // mesmo com erro
    String result = saleService.deleteSale(id);
    return new ResponseEntity<String>(result,HttpStatus.OK);
  }

  @Operation(summary="Cria uma venda", method="POST")
  @ApiResponses( value = {
    @ApiResponse(responseCode = "200", description="Venda criada com sucesso"),
    @ApiResponse(responseCode = "400", description="Parâmetros inválidos"),
  } )
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
