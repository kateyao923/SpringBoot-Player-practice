package com.example.demo.domain;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Table(name = "players")
@Getter
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;


    private String birthYear;

    private String birthDay;

    private String birthMonth;


}
 //2 apis . getAllplayers
