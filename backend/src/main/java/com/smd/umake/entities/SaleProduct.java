package com.smd.umake.entities;

import java.io.Serializable;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Embeddable
class SaleProductKey implements Serializable{
  @Column(name="id_sale")
  UUID sale_id;

  @Column(name="id_product")
  UUID product_id;
}

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

