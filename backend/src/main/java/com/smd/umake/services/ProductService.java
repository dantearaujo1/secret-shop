package com.smd.umake.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smd.umake.entities.Product;
import com.smd.umake.repositories.ProductRepository;

@Service
public class ProductService{

  @Autowired
  private ProductRepository productRepository;

  public Product getProductById(UUID id) throws Exception {
    Optional<Product> oProduct = productRepository.findById(id);
    return oProduct.get();
  }
  public List<Product> getProducts() throws Exception {
    List<Product> products = productRepository.findAll();
    return products;
  }

}
