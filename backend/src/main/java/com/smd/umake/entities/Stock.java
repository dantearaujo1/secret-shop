package com.smd.umake.entities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity(name="Stock")
@Table(name="stock")
public class Stock{

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


