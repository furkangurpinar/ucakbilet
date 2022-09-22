package com.example.ucakbilet.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="company")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="companyID")
    private int id;

    @Column(name="CompanyName")
    private String companyName;

    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="voyageID")
    private List<Voyage> voyages;



}
