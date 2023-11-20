package com.smd.umake.entities;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity(name="Branch")
@Table(name="branch")
public class Branch{

  @Id
  @Column(name="id_branch")
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @Column(name="name")
  private String name;

  @JsonManagedReference
  @OneToMany(mappedBy = "branch")
  private Set<Stock> stock = new HashSet<>();

  @Column(name="CEP")
  private String CEP;
  @Column(name="street")
  private String street;
  @Column(name="number")
  private int number;
  @Column(name="city")
  private String city;
  @Column(name="state")
  private String state;
}
