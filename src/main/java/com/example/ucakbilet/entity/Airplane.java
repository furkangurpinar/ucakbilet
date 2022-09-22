package com.example.ucakbilet.entity;


import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="airplane")
@Data
@AllArgsConstructor
public class Airplane {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;

    @Column(name="Baggage")
    private String baggage;

    @Column(name="Seat")
    private int seat;

    @Column(name="Model")
    private String Model;




    public Airplane() {

    }
}
