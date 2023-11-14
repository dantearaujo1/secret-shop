package com.smd.umake.controllers;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.smd.umake.entities.Product;
import com.smd.umake.services.ProductService;

@RestController
public class ProductController{

  @Autowired
  private ProductService productService;

  @GetMapping("/api/product/{id}")
  public Product getProductById(@PathVariable UUID id) throws Exception {
    return productService.getProductById(id);
  }

  @GetMapping("/api/product/")
  public List<Product> getProducts() throws Exception {
    return productService.getProducts();
  }

}
