package com.example.ucakbilet.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="voyage")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Voyage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="voyageID")
    private int id;

    @Column(name="Price")
    private long price;

    @Column(name="Clock")
    private String clock;

    @Column(name="Date")
    private String date;

    @Column(name="Status")
    private String status;

    @ManyToOne
    @JoinColumn(name="id")
    private Airplane airplane;

    @ManyToOne
    @JoinColumn(name="routeID")
    private Route route;






}
