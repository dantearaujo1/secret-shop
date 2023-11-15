package com.smd.umake.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smd.umake.dtos.ProductDTO;
import com.smd.umake.entities.Product;
import com.smd.umake.entities.ProductCat;
import com.smd.umake.repositories.ProductCatRepository;
import com.smd.umake.repositories.ProductRepository;

@Service
public class ProductService{

  @Autowired
  private ProductRepository productRepository;
  @Autowired
  private ProductCatRepository categoryRepository;

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

  public Product createProduct(ProductDTO newProduct) throws Exception {
    Product prod = new Product();
    prod.setName(newProduct.getName());
    prod.setDescription(newProduct.getDescription());
    prod.setBrand(newProduct.getBrand());
    prod.setPrice(newProduct.getPrice());

    String categoryID = newProduct.getCategoryID();
    if ( categoryID == null || (categoryID.isBlank()) ){
      Product oProduct = productRepository.save(prod);
      return oProduct;
    }

    UUID categoryUUID = UUID.fromString(categoryID);
    Optional<ProductCat> category = categoryRepository.findById(categoryUUID);
    if (category.isPresent()){
      prod.setCategory(category.get());
    }

    Product oProduct = productRepository.save(prod);
    return oProduct;
  }

  public Product updateProduct(UUID id, ProductDTO newProduct) throws Exception {
    Optional<Product> oProduct = productRepository.findById(id);
    // TODO: Implementar o update total
    if (oProduct.isPresent()){
      return oProduct.get();
    }
    return null;
  }

  public Product updatePartialProduct(UUID id, ProductDTO newProduct) throws Exception {
    Optional<Product> oProduct = productRepository.findById(id);
    // TODO: Implementar o update parcial
    if (oProduct.isPresent()){
      return oProduct.get();
    }
    return null;
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
