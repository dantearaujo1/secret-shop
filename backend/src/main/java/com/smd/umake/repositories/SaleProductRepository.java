package com.smd.umake.repositories;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smd.umake.entities.SaleProduct;

public interface SaleProductRepository extends JpaRepository<SaleProduct,UUID>{

}
