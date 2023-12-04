package com.smd.umake.entities;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name="Client")
@Table(name="client")
public class Client{

  @Id
  @Column(name="id_client")
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @Column(name="name", length=60, nullable=false)
  private String name;

  @JsonManagedReference
  @OneToMany(mappedBy="client",cascade=CascadeType.ALL, orphanRemoval = true)
  private List<ClientContact> contacts;

  @OneToMany(mappedBy="client",cascade=CascadeType.ALL)
  private Set<Sale> shopping = new HashSet<>();

}

