package com.upc.edu.pe.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "Promotion")
@Data
public class Promotion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(length = 50, nullable = false)
    private String name;

    private String description;

}
