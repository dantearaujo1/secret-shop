package com.smd.umake.dtos;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BranchDTO {

  @NotEmpty(message="Name shouldn't be null or empty")
  @Min(value=3,message="Minimum name size is 3")
  private String name;
  @Pattern(regexp = "^\\d{5}-\\d{3}", message="Invalid CEP")
  private String CEP;
  private String street;
  @Pattern(regexp = "^\\d{10}", message="Invalid input for number field")
  private String number;
  private String city;
  private String state;
}
