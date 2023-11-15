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
  public Product getProductByName(String name) throws Exception {
    // WARN: tem que checar se n ta nulo
    Optional<Product> oProduct = productRepository.findDistinctByName(name);
    return oProduct.get();
  }
  public List<Product> getProducts() throws Exception {
    List<Product> products = productRepository.findAll();
    return products;
  }

  public Product createProduct(Product newProduct) throws Exception {
    Product oProduct = productRepository.save(newProduct);
    return oProduct;
  }

  public Product updateProduct(Product newProduct) throws Exception {
    Product oProduct = productRepository.save(newProduct);
    return oProduct;
  }

  public String deleteProduct(UUID id) throws Exception {
    Optional<Product> oProduct = productRepository.findById(id);
    if (oProduct.isPresent()){
      productRepository.delete(oProduct.get());
      return "Product deleted!";
    } else {
      return "Could't delete the product with this id!";
    }
  }

}
