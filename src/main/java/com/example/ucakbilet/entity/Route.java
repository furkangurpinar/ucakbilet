package com.example.ucakbilet.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="route")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Route {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="routeID")
    private int id;

    @Column(name="departureAirport")
    private String departureAirport;

    @Column(name="arrivalAirport")
    private String arrivalAirport;


    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="airportID")
    private List<Airport> airports;


}
