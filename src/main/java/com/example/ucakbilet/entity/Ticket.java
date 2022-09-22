package com.example.ucakbilet.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="ticket")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @ManyToOne
    @JoinColumn(name="classID")
    private Class aClass;

    @ManyToOne
    @JoinColumn(name="voyageID")
    private Voyage voyage;

    @ManyToOne
    @JoinColumn(name="cardID")
    private Card card;



}
