package com.smd.umake.repositories;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smd.umake.entities.ProductCat;

public interface ProductCatRepository extends JpaRepository<ProductCat,UUID>{

}
