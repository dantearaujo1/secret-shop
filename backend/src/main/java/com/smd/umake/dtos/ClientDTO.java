package com.smd.umake.dtos;

import java.util.List;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ClientDTO {
  @NotEmpty(message="Name shouldn't be null or empty")
  private String name;
  @NotEmpty
  private List<String> ddd;
  @NotEmpty
  private List<String> phone;
}
