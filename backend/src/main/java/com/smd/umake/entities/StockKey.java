package com.smd.umake.entities;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class StockKey implements Serializable{
  @Column(name="id_product")
  UUID product_id;

  @Column(name="id_branch")
  UUID branch_id;

  @Override
  public int hashCode() {
      return Objects.hash(product_id, branch_id);
  }

  @Override
  public boolean equals(Object obj) {
      if (this == obj)
          return true;
      if (obj == null)
          return false;
      if (getClass() != obj.getClass())
          return false;
      StockKey other = (StockKey) obj;
      return Objects.equals(branch_id, other.getBranch_id())
              && Objects.equals(product_id, other.getProduct_id());
  }
}
