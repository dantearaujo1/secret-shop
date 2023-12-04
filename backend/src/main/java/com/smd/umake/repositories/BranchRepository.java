package com.smd.umake.repositories;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smd.umake.entities.Branch;

public interface BranchRepository extends JpaRepository<Branch,UUID>{

  public Optional<Branch> findDistinctByName(String name);
}
