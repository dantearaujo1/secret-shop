package com.smd.umake.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smd.umake.entities.ProductCat;
import com.smd.umake.repositories.ProductCatRepository;

@Service
public class ProductCategoryService{

  @Autowired
  private ProductCatRepository categoryRepository;

  public ProductCat getCategoryById(UUID id) throws Exception {
    Optional<ProductCat> oCategory = categoryRepository.findById(id);
    return oCategory.get();
  }
  public List<ProductCat> getCategories() throws Exception {
    List<ProductCat> categories = categoryRepository.findAll();
    return categories;
  }
  public ProductCat getCategoryByName(String name) throws Exception {
    // WARN: tem que checar se n ta nulo
    Optional<ProductCat> category = categoryRepository.findDistinctCategoryByName(name);
    return category.get();
  }

  public ProductCat createCategory(ProductCat newProduct) throws Exception {
    ProductCat oCategory = categoryRepository.save(newProduct);
    return oCategory;
  }

  public ProductCat updateCategory(ProductCat newProduct) throws Exception {
    ProductCat oCategory = categoryRepository.save(newProduct);
    return oCategory;
  }

  public String deleteCategory(UUID id) throws Exception {
    Optional<ProductCat> oCategory = categoryRepository.findById(id);
    if (oCategory.isPresent()){
      categoryRepository.delete(oCategory.get());
      return "Category deleted!";
    } else {
      return "Could't delete the category with this id!";
    }
  }

}
