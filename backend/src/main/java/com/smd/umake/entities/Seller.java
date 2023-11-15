package com.smd.umake.entities;

import java.util.HashSet;
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
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity(name="Seller")
@Table(name="seller")
public class Seller{

  @Id
  @Column(name="id_seller")
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @Column(name="name", length=60, nullable=false)
  private String name;

  @OneToMany(mappedBy="seller",cascade=CascadeType.ALL)
  private Set<Sale> sales = new HashSet<>();
}
