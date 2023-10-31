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
class StockKey implements Serializable{
  @Column(name="id_product")
  UUID product_id;

  @Column(name="id_branch")
  UUID branch_id;
}

@Entity(name="Stock")
@Table(name="stock")
class Stock{

  @EmbeddedId
  StockKey id;

  @ManyToOne
  @MapsId("id")
  @JoinColumn(name = "id_branch")
  Branch branch;

  @ManyToOne
  @MapsId("id")
  @JoinColumn(name = "id_product")
  Product product;

  int quantity;

}


