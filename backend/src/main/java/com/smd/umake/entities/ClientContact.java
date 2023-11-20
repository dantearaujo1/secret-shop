package com.smd.umake.entities;

import java.io.Serializable;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity(name="ClientContact")
public class ClientContact implements Serializable {

  @Id
  @ManyToOne(fetch= FetchType.LAZY)
  @JsonBackReference
  @JoinColumn(name="id_client")
  private Client client;
  @Id
  private String ddd;
  @Id
  private String phoneNumber;

  @Override
  public int hashCode() {
      return Objects.hash(client, ddd, phoneNumber);
  }

  @Override
  public boolean equals(Object obj) {
      if (this == obj)
          return true;
      if (obj == null)
          return false;
      if (getClass() != obj.getClass())
          return false;
      ClientContact other = (ClientContact) obj;
      return Objects.equals(client, other.getClient())
              && Objects.equals(ddd, other.getDdd())
              && Objects.equals(phoneNumber,other.getPhoneNumber());
  }

}
