package com.smd.umake.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BranchDTO {
  private String name;
  private String CEP;
  private String street;
  private String number;
  private String city;
  private String state;
}
