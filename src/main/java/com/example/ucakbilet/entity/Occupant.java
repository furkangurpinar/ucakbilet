package com.example.ucakbilet.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="occupant")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Occupant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="userID")
    private int id;

    @Column(name="mail")
    private String mail;

    @Column(name="password")
    private String password;

    @Column(name="role")
    private String role;

    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="companyID")
    private List<Company> companies;



}
