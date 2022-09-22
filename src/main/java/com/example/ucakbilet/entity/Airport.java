package com.example.ucakbilet.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="airport")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Airport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="airportID")
    private int id;

    @Column(name="airportName")
    private double airportName;

    @ManyToOne
    @JoinColumn(name="townID")
    private Town town;


}
