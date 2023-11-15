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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.smd.umake.dtos.ProductDTO;
import com.smd.umake.entities.Product;
import com.smd.umake.entities.ProductCat;
import com.smd.umake.services.ProductCategoryService;
import com.smd.umake.services.ProductService;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController{

  @Autowired
  private ProductService productService;
  @Autowired
  private ProductCategoryService categoryService;

  @GetMapping("/{id}")
  public ResponseEntity<Product> getProductById(@PathVariable UUID id) throws Exception {
    Product p = productService.getProductById(id);
    if (p == null){
      throw new Exception();
    } else {
      return new ResponseEntity<> (p,HttpStatus.OK);
    }
  }
  @GetMapping("")
  public ResponseEntity<Product> getProductById(@RequestParam("name") String name) throws Exception {
    Product p = productService.getProductByName(name);
    if (p == null){
      throw new Exception();
    } else {
      return new ResponseEntity<> (p,HttpStatus.OK);
    }
  }
  @GetMapping("/")
  public ResponseEntity<List<Product>> getProducts() throws Exception {
    List<Product> p = productService.getProducts();
    if (p == null){
      throw new Exception();
    } else {
      return new ResponseEntity<> (p,HttpStatus.OK);
    }
  }
  @DeleteMapping("/{id}")
  public ResponseEntity<String> deleteProductById(@PathVariable UUID id) throws Exception {
    String result = productService.deleteProduct(id);
    return new ResponseEntity<String>(result,HttpStatus.OK);
  }
  @PostMapping("/")
  public ResponseEntity<Product> addProduct(@RequestBody ProductDTO  newProduct) throws Exception{
    Product prod = productService.createProduct(newProduct);
    if (prod == null){
      throw new Exception();
    } else {
      return new ResponseEntity<Product>(prod, HttpStatus.CREATED);
    }

  }
  @PatchMapping("/{id}")
  public ResponseEntity<Product> updatePartialProductById(@PathVariable UUID id, @RequestBody ProductDTO updatedData) throws Exception {
    Product prod = productService.updatePartialProduct(id, updatedData);
    if (prod == null){
      throw new Exception();
    } else {
      return new ResponseEntity<Product>(prod, HttpStatus.CREATED);
    }
  }
  @GetMapping("/category")
  public ResponseEntity<List<ProductCat>> getCategories() throws Exception {
    List<ProductCat> c = categoryService.getCategories();
    if (c == null){
      throw new Exception();
    } else {
      return new ResponseEntity<> (c,HttpStatus.OK);
    }
  }
  @GetMapping(path = "/category", params = "name")
  public ResponseEntity<ProductCat> getCategoryByName(@RequestParam("name") String name) throws Exception {
    ProductCat c = categoryService.getCategoryByName(name);
    if (c == null){
      throw new Exception();
    } else {
      return new ResponseEntity<> (c,HttpStatus.OK);
    }
  }
  @GetMapping(path = "/category/{id}")
  public ResponseEntity<ProductCat> getCategoryByName(@PathVariable("id") UUID id) throws Exception {
    ProductCat c = categoryService.getCategoryById(id);
    if (c == null){
      throw new Exception();
    } else {
      return new ResponseEntity<> (c,HttpStatus.OK);
    }
  }
  @DeleteMapping("category/{id}")
  public String deleteCategoryById(@PathVariable UUID id) throws Exception {
    // TODO: Implementar checagem de nulo
    String result = categoryService.deleteCategory(id);
    return result;
  }
  @PostMapping("/category")
  public ResponseEntity<ProductCat> addCategory(@RequestBody ProductCat  newCategory) throws Exception{
    ProductCat cat = categoryService.createCategory(newCategory);
    if (cat == null){
      throw new Exception();
    } else {
      return new ResponseEntity<ProductCat>(cat, HttpStatus.CREATED);
    }

  }


}
