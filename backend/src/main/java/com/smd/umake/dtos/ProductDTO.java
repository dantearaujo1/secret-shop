package com.smd.umake.dtos;

import java.math.BigDecimal;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductDTO {

  @NotEmpty
  private String categoryID;
  @NotEmpty
  private String name;
  private String description;
  private String brand;

  @NotEmpty
  @Min(0)
  private BigDecimal price;

}
