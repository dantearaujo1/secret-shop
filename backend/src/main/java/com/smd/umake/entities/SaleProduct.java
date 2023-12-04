package com.smd.umake.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

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

  @JsonBackReference
  @ManyToOne
  @MapsId("id")
  @JoinColumn(name = "id_product")
  Product product;

  @ManyToOne
  @MapsId("id")
  @JoinColumn(name = "id_sale")
  @JsonBackReference
  Sale sale;

  int quantity;

}

