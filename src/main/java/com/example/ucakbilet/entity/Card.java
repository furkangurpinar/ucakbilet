package com.example.ucakbilet.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="card")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="cardID")
    private int id;

    @Column(name="ED")
    private String endDate;

    @Column(name="cvc")
    private String cvc;

    @Column(name="cardNumber")
    private String cardNumber;

    @ManyToOne
    @JoinColumn(name="id")
    private Passenger passenger;



}
