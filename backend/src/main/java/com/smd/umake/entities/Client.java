package com.smd.umake.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity(name="Client")
@Table(name="client")
public class Client{

  @Id
  @Column(name="id_client")
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @Column(name="name", length=60, nullable=false)
  private String name;

  // WARN: PAREI AQUI
  @OneToMany(mappedBy="client",cascade=CascadeType.ALL, orphanRemoval = true)
  private List<ClientContact> contacts;

  @OneToMany(mappedBy="client",cascade=CascadeType.ALL)
  private Set<Sale> shopping = new HashSet<>();

}

