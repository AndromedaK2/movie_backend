package com.usach.movie_backend.genders.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name ="genders_series")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class GenderSerie {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_gender_serie")
    private Integer idGenderSerie;
    @Column(name = "id_gender")
    private Integer idGender;
    @Column(name = "id_serie")
    private Integer idSerie;
}
