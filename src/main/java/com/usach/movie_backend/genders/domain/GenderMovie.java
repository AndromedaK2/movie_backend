package com.usach.movie_backend.genders.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name ="genders_movies")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class GenderMovie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_gender_movie")
    private Integer idGenderMovie;
    @Column(name = "id_gender")
    private Integer idGender;
    @Column(name = "id_movie")
    private Integer idMovie;
}
