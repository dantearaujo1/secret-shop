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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/v1/branch")
@Tag(name="filial")
public class BranchController{

  @Autowired
  private BranchService branchService;
  @Autowired
  private ProductService productService;
  @Autowired
  private StockService stockService;

  @Operation(summary="Retorna a filial buscado pelo ID", method="GET")
  @ApiResponses( value = {
    @ApiResponse(responseCode = "200", description="Filial encontrada e retornada com sucesso"),
    @ApiResponse(responseCode = "404", description="Filial não encontrada"),
    @ApiResponse(responseCode = "400", description="Parâmetros inválidos"),
  } )
  @GetMapping("/{id}")
  public ResponseEntity<Branch> getBranchById(@PathVariable String id) throws Exception {
    Branch p = branchService.getBranchById(id);
    if (p == null){
      // WARN: Aqui a gente devia enviar uma resposta com o status correto
      // de falha, no caso :)!
      // TODO: Usar entity not found Exception
      throw new Exception("Não encontramos a filial!");
    } else {
      return new ResponseEntity<> (p,HttpStatus.OK);
    }
  }
  @Operation(summary="Retorna a filial buscado pelo nome", method="GET")
  @ApiResponses( value = {
    @ApiResponse(responseCode = "200", description="Filial encontrada e retornada com sucesso"),
    @ApiResponse(responseCode = "404", description="Filial não encontrada"),
    @ApiResponse(responseCode = "400", description="Parâmetros inválidos"),
  } )
  @GetMapping("/")
  public ResponseEntity<Branch> getBranchByName(@RequestParam("name") String name) throws Exception {
    Branch p = branchService.getBranchByName(name);
    if (p == null){
      // TODO: Usar entity not found Exception
      throw new Exception();
    } else {
      return new ResponseEntity<> (p,HttpStatus.OK);
    }
  }
  @Operation(summary="Retorna uma lista de produtos de uma filial pelo ID da filial", method="GET")
  @ApiResponses( value = {
    @ApiResponse(responseCode = "200", description="Produtos encontrados e retornado com sucesso"),
    @ApiResponse(responseCode = "404", description="Filial não encontrada"),
    @ApiResponse(responseCode = "400", description="Parâmetros inválidos"),
  } )
  @GetMapping("/{id}/stock")
  public ResponseEntity<List<Product>> getProductsFromBranch(@PathVariable String id) throws Exception {
    List<Product> products = stockService.getProducts(id);
    return new ResponseEntity<> (products,HttpStatus.OK);
  }

  @Operation(summary="Retorna uma lista com todas as filiais no banco", method="GET")
  @ApiResponses( value = {
    @ApiResponse(responseCode = "200", description="Filiais encontradas e retornadas com sucesso"),
    @ApiResponse(responseCode = "404", description="Filiais não encontradas"),
    @ApiResponse(responseCode = "400", description="Parâmetros inválidos"),
  } )
  @GetMapping("")
  public ResponseEntity<List<Branch>> getBranchs() throws Exception {
    List<Branch> p = branchService.getBranchs();
    if (p == null){
      throw new Exception();
    } else {
      return new ResponseEntity<> (p,HttpStatus.OK);
    }
  }

  @Operation(summary="Deleta a filial pelo ID", method="DELETE")
  @ApiResponses( value = {
    @ApiResponse(responseCode = "200", description="Deletada com sucesso"),
    @ApiResponse(responseCode = "404", description="Filial não encontrada"),
    @ApiResponse(responseCode = "400", description="Parâmetros inválidos"),
  } )
  @DeleteMapping("/{id}")
  public ResponseEntity<String> deleteBranchById(@PathVariable String id) throws Exception {
    String result = branchService.deleteBranch(id);
    return new ResponseEntity<String>(result,HttpStatus.OK);
  }


  @Operation(summary="Cria uma filial com os parâmetros passadas", method="POST")
  @ApiResponses( value = {
    @ApiResponse(responseCode = "200", description="Filial criada com sucesso"),
    @ApiResponse(responseCode = "400", description="Parâmetros inválidos"),
  } )
  @PostMapping("/")
  public ResponseEntity<Branch> addBranch(@RequestBody BranchDTO  newBranch) throws Exception{
    Branch bra = branchService.createBranch(newBranch);
    if (bra == null){
      throw new Exception();
    } else {
      return new ResponseEntity<Branch>(bra, HttpStatus.CREATED);
    }

  }
  @Operation(summary="Adiciona um produto na filial", method="POST")
  @ApiResponses( value = {
    @ApiResponse(responseCode = "200", description="Produto adicionado com sucesso!"),
    @ApiResponse(responseCode = "404", description="Alguma entidade (Produto ou Filial) não foi encontrada"),
    @ApiResponse(responseCode = "400", description="Parâmetros inválidos"),
  } )
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
