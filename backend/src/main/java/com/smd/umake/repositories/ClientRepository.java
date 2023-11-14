package com.smd.umake.repositories;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smd.umake.entities.Client;

public interface ClientRepository extends JpaRepository<Client,UUID>{

}
