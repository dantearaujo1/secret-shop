package com.smd.umake.entities;

import java.util.Set;
import java.util.HashSet;
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
@Entity(name="ProductCat")
@Table(name="product_cat")
public class ProductCat{

  @Id
  @Column(name="id_product_cat")
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @Column(name="name", length=30, nullable=false)
  private String name;

  @Column(name="description", length=255, nullable=true)
  private String description;

  @OneToMany(mappedBy="category",cascade=CascadeType.ALL)
  private Set<Product> products = new HashSet<>();
}
