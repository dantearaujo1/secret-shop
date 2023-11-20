package com.smd.umake.repositories;
import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smd.umake.entities.Branch;
import com.smd.umake.entities.Product;
import com.smd.umake.entities.Stock;
import com.smd.umake.entities.StockKey;

public interface StockRepository extends JpaRepository<Stock,StockKey>{
  public List<Stock> findAllByBranchId(UUID id);
  public List<Stock> findAllByProductId(UUID id);
}
