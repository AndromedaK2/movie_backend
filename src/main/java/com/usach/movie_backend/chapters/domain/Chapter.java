package com.usach.movie_backend.chapters.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "chapters")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Chapter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_chapter")
    private Integer idChapter;
    @Column(name = "duration")
    private String duration;
    @Column(name = "synopsis")
    private String synopsis;
    @Column(name = "url_video")
    private String urlVideo;
    @Column(name = "release_date")
    private Date releaseDate;
    @Column(name = "id_season")
    private Integer idSeason;
    @Column(name = "chapter_number")
    private Integer chapterNumber;
}
