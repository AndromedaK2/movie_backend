package com.usach.movie_backend.seasons.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "seasons")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Season {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_season")
    private Integer idSeason;
    @Column(name = "release_date")
    private Date releaseDate;
    @Column(name = "synopsis")
    private String synopsis;
    @Column(name = "id_serie")
    private Integer idSerie;
    @Column(name = "title")
    private String title;
    @Column(name = "number")
    private Integer number;



}
