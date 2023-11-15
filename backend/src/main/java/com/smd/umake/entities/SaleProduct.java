package com.smd.umake.entities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;


@Entity(name="SaleProduct")
@Table(name="sale_product")
public class SaleProduct{

  @EmbeddedId
  SaleProductKey id;

  @ManyToOne
  @MapsId("id")
  @JoinColumn(name = "id_product")
  Product product;

  @ManyToOne
  @MapsId("id")
  @JoinColumn(name = "id_sale")
  Sale sale;

  int quantity;

}

