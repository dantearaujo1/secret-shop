package com.smd.umake.entities;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

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

@Entity(name="Sale")
@Table(name="sale")
public class Sale{

  @Id
  @Column(name="id_sale")
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @ManyToOne(fetch= FetchType.LAZY)
  @JoinColumn(name="id_seller")
  private Seller seller;

  @ManyToOne(fetch= FetchType.LAZY)
  @JoinColumn(name="id_client")
  private Client client;

  @ManyToOne(fetch= FetchType.LAZY)
  @JoinColumn(name="id_branch")
  private Branch branch;

  @OneToMany(mappedBy = "sale")
  private List<SaleProduct> sale_product;

}
