package com.smd.umake.controllers;
import java.util.List;
import java.util.UUID;

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
  public Product getProductById(@PathVariable UUID id) throws Exception {
    return productService.getProductById(id);
  }
  @GetMapping("")
  public Product getProductById(@RequestParam("name") String name) throws Exception {
    return productService.getProductByName(name);
  }
  @DeleteMapping("/{id}")
  public String deleteProductById(@PathVariable UUID id) throws Exception {
    String result = productService.deleteProduct(id);
    return result;

  }
  @DeleteMapping("category/{id}")
  public String deleteCategoryById(@PathVariable UUID id) throws Exception {
    String result = categoryService.deleteCategory(id);
    return result;
  }
  @GetMapping("/")
  public List<Product> getProducts() throws Exception {
    return productService.getProducts();
  }

  @GetMapping("/category")
  public List<ProductCat> getCategories() throws Exception {
    return categoryService.getCategories();
  }
  @GetMapping(path = "/category", params = "name")
  public ProductCat getCategoryByName(@RequestParam("name") String name) throws Exception {
    return categoryService.getCategoryByName(name);
  }

  @PostMapping("/category")
  public ResponseEntity<ProductCat> addProduct(@RequestBody ProductCat  newCategory) throws Exception{
    ProductCat cat = categoryService.createCategory(newCategory);
    if (cat == null){
      throw new Exception();
    } else {
      return new ResponseEntity<ProductCat>(cat, HttpStatus.CREATED);
    }

  }

  @PostMapping("/")
  public ResponseEntity<Product> addProduct(@RequestBody Product  newProduct) throws Exception{
    Product prod = productService.createProduct(newProduct);
    if (prod == null){
      throw new Exception();
    } else {
      return new ResponseEntity<Product>(prod, HttpStatus.CREATED);
    }

  }

}
