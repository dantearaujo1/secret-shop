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

