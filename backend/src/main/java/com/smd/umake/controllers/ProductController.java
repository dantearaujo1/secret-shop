package com.smd.umake.controllers;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.smd.umake.dtos.CategoryDTO;
import com.smd.umake.dtos.ProductDTO;
import com.smd.umake.entities.Product;
import com.smd.umake.entities.ProductCat;
import com.smd.umake.services.ProductCategoryService;
import com.smd.umake.services.ProductService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/v1/product")
@Tag(name="product")
public class ProductController{

  @Autowired
  private ProductService productService;
  @Autowired
  private ProductCategoryService categoryService;

  @Operation(summary="Retorna o produto buscado pelo ID", method="GET")
  @ApiResponses( value = {
    @ApiResponse(responseCode = "200", description="Produto encontrado e retornado com sucesso"),
    @ApiResponse(responseCode = "404", description="Produto não encontrado"),
    @ApiResponse(responseCode = "400", description="Parâmetros inválidos"),
  } )
  @GetMapping("/{id}")
  public ResponseEntity<Product> getProductById(@PathVariable String id) throws Exception {
    Product p = productService.getProductById(id);
    if (p == null){
      throw new Exception();
    } else {
      return new ResponseEntity<> (p,HttpStatus.OK);
    }
  }

  @Operation(summary="Retorna o produto buscado pelo nome", method="GET")
  @ApiResponses( value = {
    @ApiResponse(responseCode = "200", description="Produto encontrado e retornado com sucesso"),
    @ApiResponse(responseCode = "404", description="Produto não encontrado"),
    @ApiResponse(responseCode = "400", description="Parâmetros inválidos"),
  } )
  @GetMapping("/")
  public ResponseEntity<Product> getProductByName(@RequestParam("name") String name) throws Exception {
    Product p = productService.getProductByName(name);
    if (p == null){
      throw new Exception();
    } else {
      return new ResponseEntity<> (p,HttpStatus.OK);
    }
  }

  @Operation(summary="Retorna todos os produtos", method="GET")
  @ApiResponses( value = {
    @ApiResponse(responseCode = "200", description="Lista de Produtos retornada com sucesso"),
  } )
  @GetMapping("")
  public ResponseEntity<List<Product>> getProducts() throws Exception {
    List<Product> p = productService.getProducts();
    if (p == null){
      throw new Exception();
    } else {
      return new ResponseEntity<> (p,HttpStatus.OK);
    }
  }

  @Operation(summary="Deleta produto baseado no ID passado", method="DELETE")
  @ApiResponses( value = {
    @ApiResponse(responseCode = "200", description="Produto deletado com sucesso"),
    @ApiResponse(responseCode = "404", description="Produto não encontrado"),
    @ApiResponse(responseCode = "400", description="Parâmetros inválidos"),
  } )
  @DeleteMapping("/{id}")
  public ResponseEntity<String> deleteProductById(@PathVariable UUID id) throws Exception {
    String result = productService.deleteProduct(id);
    return new ResponseEntity<String>(result,HttpStatus.OK);
  }

  @Operation(summary="Cria produto globalmente (não é específico para filial)", method="POST")
  @ApiResponses( value = {
    @ApiResponse(responseCode = "200", description="Produto criado com sucesso"),
    @ApiResponse(responseCode = "400", description="Parâmetros inválidos"),
  } )
  @PostMapping("/")
  public ResponseEntity<Product> addProduct(@RequestBody ProductDTO  newProduct) throws Exception{
    Product prod = productService.createProduct(newProduct);
    if (prod == null){
      throw new Exception();
    } else {
      return new ResponseEntity<Product>(prod, HttpStatus.CREATED);
    }

  }

  @Operation(summary="Atualiza um produto baseado em seu ID", method="PATCH")
  @ApiResponses( value = {
    @ApiResponse(responseCode = "200", description="Produto encontrado e atualizado com sucesso"),
    @ApiResponse(responseCode = "404", description="Produto não encontrado"),
    @ApiResponse(responseCode = "400", description="Parâmetros inválidos"),
  } )
  @PatchMapping("/{id}")
  public ResponseEntity<Product> updatePartialProductById(@PathVariable UUID id, @RequestBody ProductDTO updatedData) throws Exception {
    Product prod = productService.updatePartialProduct(id, updatedData);
    if (prod == null){
      throw new Exception();
    } else {
      return new ResponseEntity<Product>(prod, HttpStatus.OK);
    }
  }

  @Operation(summary="Retorna uma lista de categorias", method="GET")
  @ApiResponses( value = {
    @ApiResponse(responseCode = "200", description="Categorias encontradas e retornadas com sucesso"),
  } )
  @GetMapping("/category")
  public ResponseEntity<List<ProductCat>> getCategories() throws Exception {
    List<ProductCat> c = categoryService.getCategories();
    if (c == null){
      throw new Exception();
    } else {
      return new ResponseEntity<> (c,HttpStatus.OK);
    }
  }

  @Operation(summary="Retorna categoria com base no nome passado", method="GET")
  @ApiResponses( value = {
    @ApiResponse(responseCode = "200", description="Categoria encontrada e retornada com sucesso"),
    @ApiResponse(responseCode = "404", description="Categoria não encontrada"),
    @ApiResponse(responseCode = "400", description="Parâmetros inválidos"),
  } )
  @GetMapping(path = "/category", params = "name")
  public ResponseEntity<ProductCat> getCategoryByName(@RequestParam("name") String name) throws Exception {
    ProductCat c = categoryService.getCategoryByName(name);
    if (c == null){
      throw new Exception();
    } else {
      return new ResponseEntity<> (c,HttpStatus.OK);
    }
  }

  @Operation(summary="Categoria retornada pelo ID", method="GET")
  @ApiResponses( value = {
    @ApiResponse(responseCode = "200", description="Categoria encontrada e retornada com sucesso"),
    @ApiResponse(responseCode = "404", description="Categoria não encontrada"),
    @ApiResponse(responseCode = "400", description="Parâmetros inválidos"),
  } )
  @GetMapping(path = "/category/{id}")
  // TODO: Ajeitar o UUID para STRING
  public ResponseEntity<ProductCat> getCategoryById(@PathVariable("id") UUID id) throws Exception {
    ProductCat c = categoryService.getCategoryById(id);
    if (c == null){
      throw new Exception();
    } else {
      return new ResponseEntity<> (c,HttpStatus.OK);
    }
  }

  @Operation(summary="Deleta categoria pelo ID", method="DELETE")
  @ApiResponses( value = {
    @ApiResponse(responseCode = "200", description="Categoria deletada com sucesso"),
    @ApiResponse(responseCode = "404", description="Categoria não encontrada"),
    @ApiResponse(responseCode = "400", description="Parâmetros inválidos"),
  } )
  @DeleteMapping("category/{id}")
  // TODO: Ajeitar o UUID para STRING
  public String deleteCategoryById(@PathVariable UUID id) throws Exception {
    // TODO: Implementar checagem de nulo
    String result = categoryService.deleteCategory(id);
    return result;
  }

  @Operation(summary="Cria categoria", method="POST")
  @ApiResponses( value = {
    @ApiResponse(responseCode = "200", description="Categoria criada e retornada com sucesso"),
    @ApiResponse(responseCode = "400", description="Parâmetros inválidos"),
  } )
  @PostMapping("/category")
  public ResponseEntity<ProductCat> addCategory(@RequestBody CategoryDTO  newCategory) throws Exception{
    ProductCat cat = categoryService.createCategory(newCategory);
    if (cat == null){
      throw new Exception();
    } else {
      return new ResponseEntity<ProductCat>(cat, HttpStatus.CREATED);
    }

  }

  @Operation(summary="Atualiza uma categoria parcialmente por meio do seu ID", method="PATCH")
  @ApiResponses( value = {
    @ApiResponse(responseCode = "200", description="Categoria atualizada e retornado com sucesso"),
    @ApiResponse(responseCode = "404", description="Produto não encontrado"),
    @ApiResponse(responseCode = "400", description="Parâmetros inválidos"),
  } )
  @PatchMapping("/category/{id}")
  public ResponseEntity<ProductCat> updatePartialCategoryById(@PathVariable String id, @RequestBody CategoryDTO updatedData) throws Exception {
    ProductCat prod = categoryService.updatePartialCategory(id, updatedData);
    if (prod == null){
      throw new Exception();
    } else {
      return new ResponseEntity<ProductCat>(prod, HttpStatus.CREATED);
    }
  }

  @Operation(summary="Atualiza uma categoria por meio do seu ID", method="PATCH")
  @ApiResponses( value = {
    @ApiResponse(responseCode = "200", description="Categoria atualizada e retornado com sucesso"),
    @ApiResponse(responseCode = "404", description="Produto não encontrado"),
    @ApiResponse(responseCode = "400", description="Parâmetros inválidos"),
  } )
  @PutMapping("/category/{id}")
  public ResponseEntity<ProductCat> updateCategoryById(@PathVariable String id, @RequestBody CategoryDTO updatedData) throws Exception {
    ProductCat prod = categoryService.updateCategory(id, updatedData);
    if (prod == null){
      throw new Exception();
    } else {
      return new ResponseEntity<ProductCat>(prod, HttpStatus.CREATED);
    }
  }


}
