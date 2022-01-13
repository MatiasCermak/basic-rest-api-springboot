package com.mcrmk.moviesApi.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="movies")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name="rating")
    private int rating;
}
