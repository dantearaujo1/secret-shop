package com.smd.umake.repositories;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smd.umake.entities.Product;

public interface ProductRepository extends JpaRepository<Product,UUID>{

  Optional<Product> findDistinctByName(String name);
}
