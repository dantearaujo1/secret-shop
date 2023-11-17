package com.smd.umake.dtos;

import java.math.BigDecimal;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductDTO {

  private String categoryID;
  private String name;
  private String description;
  private String brand;
  private BigDecimal price;

}
