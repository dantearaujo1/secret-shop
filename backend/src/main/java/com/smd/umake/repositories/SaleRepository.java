package com.smd.umake.repositories;
import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smd.umake.entities.Sale;

public interface SaleRepository extends JpaRepository<Sale,UUID>{

  List<Sale> findAllBySeller(UUID sellerId);
  List<Sale> findAllByClient(UUID clientId);
  List<Sale> findAllByBranch(UUID branchId);
}
