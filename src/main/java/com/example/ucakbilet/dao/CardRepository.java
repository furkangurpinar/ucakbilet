package com.example.ucakbilet.dao;

import com.example.ucakbilet.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<Card,Integer> {


}
