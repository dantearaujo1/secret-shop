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
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class SaleProductKey implements Serializable{
  @Column(name="id_sale")
  UUID sale_id;

  @Column(name="id_product")
  UUID product_id;

  @Override
  public int hashCode() {
      return Objects.hash(sale_id, product_id);
  }

  @Override
  public boolean equals(Object obj) {
      if (this == obj)
          return true;
      if (obj == null)
          return false;
      if (getClass() != obj.getClass())
          return false;
      SaleProductKey other = (SaleProductKey) obj;
      return Objects.equals(sale_id, other.getSale_id())
              && Objects.equals(product_id, other.getProduct_id());
  }
}
