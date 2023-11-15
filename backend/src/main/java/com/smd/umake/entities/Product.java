package com.smd.umake.entities;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.With;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="Product")
@Table(name="product")
public class Product{

  @Id
  @Column(name="id_product")
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @Column(name="price", precision=16, scale=4)
  private BigDecimal price;

  @Column(name="name", length=100, nullable=false)
  private String name;

  @Column(name="description", length=255, nullable=true)
  private String description;

  @Column(name="brand", length=50, nullable=false)
  private String brand;


  @OneToMany(mappedBy = "product")
  private List<SaleProduct> sales;

  @JsonBackReference
  @ManyToOne(fetch= FetchType.LAZY)
  @JoinColumn(name="id_product_cat")
  private ProductCat category;
}
