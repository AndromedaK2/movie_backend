package com.usach.movie_backend.series.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "series")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Serie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_serie")
    private Integer idSerie;
    @Column(name = "name")
    private String name;
    @Column(name = "synopsis")
    private String synopsis;
    @Column(name = "release_date")
    private Date releaseDate;
    @Column(name = "url_photo")
    private String urlPhoto;
    @Column(name = "trailer")
    private String trailer;
    @Column(name = "views")
    private Integer views;
    @Column(name = "qualification")
    private double qualification;
    @Column(name = "id_director")
    private Integer idDirector;
    @Column(name = "id_producer")
    private Integer idProducer;
    @Column(name = "active")
    private Boolean active;
}
