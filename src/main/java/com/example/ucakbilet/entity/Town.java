package com.example.ucakbilet.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="town")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Town {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="townID")
    private int id;

    @Column(name="townName")
    private String townName;





}
