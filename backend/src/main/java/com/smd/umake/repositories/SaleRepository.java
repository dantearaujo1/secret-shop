package com.smd.umake.repositories;
import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smd.umake.entities.Branch;
import com.smd.umake.entities.Client;
import com.smd.umake.entities.Sale;
import com.smd.umake.entities.Seller;

public interface SaleRepository extends JpaRepository<Sale,UUID>{

  List<Sale> findAllBySeller(Seller seller);
  List<Sale> findAllByClient(Client client);
  List<Sale> findAllByBranch(Branch branch);
}
