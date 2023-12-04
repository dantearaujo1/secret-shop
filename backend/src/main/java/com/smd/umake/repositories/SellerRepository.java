package com.smd.umake.repositories;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smd.umake.entities.Seller;

public interface SellerRepository extends JpaRepository<Seller,UUID>{
  public Optional<Seller> findDistinctByName(String name);
}
