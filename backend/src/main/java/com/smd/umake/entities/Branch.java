package com.smd.umake.entities;

import java.util.List;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity(name="Branch")
@Table(name="branch")
public class Branch{

  @Id
  @Column(name="id_branch")
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @Column(name="name")
  private String name;

  @OneToMany(mappedBy = "branch")
  private List<Stock> stock;

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
