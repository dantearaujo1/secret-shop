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
public class SaleDTO {
  @NotEmpty(message="Seller ID shouldn't be null or empty")
  private String seller;
  @NotEmpty(message="Branch ID shouldn't be null or empty")
  private String branch;
  @NotEmpty(message="Client ID shouldn't be null or empty")
  private String client;
  @NotEmpty
  @Min(0)
  private BigDecimal total;
}
