package com.example.ucakbilet.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="passenger")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Passenger {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;

    @Column
    private String firstName;

    @Column(name="surname")
    private String lastName;

    @Column(name="mail")
    private String mail;

    @Column(name="password")
    private String password;

    @Column(name="telnum")
    private String telNum;


}
