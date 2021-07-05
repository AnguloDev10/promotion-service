package com.upc.edu.pe.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;

import lombok.Data;

@Entity
@Table(name = "Disccount")
@Data
public class Disccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private Float procentaje;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "promotion_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Promotion promotion;

}
