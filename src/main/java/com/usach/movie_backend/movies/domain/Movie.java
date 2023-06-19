package com.usach.movie_backend.movies.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "movies")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_movie")
    private Integer idMovie;
    @Column(name = "title")
    private String title;
    @Column(name = "synopsis")
    private String synopsis;
    @Column(name = "duration")
    private String duration;
    @Column(name = "release_date")
    private Date releaseDate;
    @Column(name = "url_video")
    private String urlVideo;
    @Column(name = "url_photo")
    private String urlPhoto;
    @Column(name = "url_trailer")
    private String urlTrailer;
    @Column(name = "views")
    private Integer views;
    @Column(name = "note")
    private String note;
    @Column(name = "id_director")
    private Integer idDirector;
    @Column(name = "id_producer")
    private Integer idProducer;
    @Column(name = "active")
    private Boolean active;
}
