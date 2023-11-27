package com.smd.umake.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smd.umake.dtos.CategoryDTO;
import com.smd.umake.entities.ProductCat;
import com.smd.umake.exceptions.ArgumentInvalidException;
import com.smd.umake.exceptions.EntityNotFoundException;
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
    if (category.isPresent()){
      return category.get();
    }
    throw new EntityNotFoundException("Categoria não encontrada!");
  }

  public ProductCat createCategory(CategoryDTO category_data) throws Exception {
    ProductCat category = new ProductCat();
    category.setName(category_data.getName());
    category.setDescription(category_data.getDescription());
    ProductCat oCategory = categoryRepository.save(category);
    return oCategory;
  }

  public ProductCat updateCategory(String categoryID, CategoryDTO updated) throws Exception {
    try {
      UUID id = UUID.fromString(categoryID);
      Optional<ProductCat> oCategory = categoryRepository.findById(id);
      if (oCategory.isPresent()){
        ProductCat c = oCategory.get();
        c.setName(updated.getName());
        c.setDescription(updated.getName());
        categoryRepository.save(c);
        return c;
      } else {
        throw new EntityNotFoundException("Categoria não encontrada!");
      }

    } catch (IllegalArgumentException e){
      throw new ArgumentInvalidException("Id não válido!");
    }
  }

  public String deleteCategory(UUID id) throws Exception {
    Optional<ProductCat> oCategory = categoryRepository.findById(id);
    if (oCategory.isPresent()){
      categoryRepository.delete(oCategory.get());
      return "Category deleted!";
    } else {
      throw new EntityNotFoundException("Categoria não encontrada para deleção!");
    }
  }
  public ProductCat updatePartialCategory(String categoryID, CategoryDTO updatedData) throws Exception {
    try {
      UUID id = UUID.fromString(categoryID);
      Optional<ProductCat> oCategory = categoryRepository.findById(id);
      if (oCategory.isPresent()){
        ProductCat c = oCategory.get();
        if (!updatedData.getName().isEmpty()){
          c.setName(updatedData.getName());
        }
        if (!updatedData.getDescription().isEmpty()){
          c.setDescription(updatedData.getDescription());
        }
        categoryRepository.save(c);
        return c;
      } else {
        throw new EntityNotFoundException("Categoria não encontrada!");
      }

    } catch (IllegalArgumentException e){
      throw new ArgumentInvalidException("Id não válido!");
    }
  }

}

