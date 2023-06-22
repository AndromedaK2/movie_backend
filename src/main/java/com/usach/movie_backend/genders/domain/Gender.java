package com.usach.movie_backend.genders.domain;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.usach.movie_backend.series.domain.Serie;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Set;

@Entity
@Table(name ="genders")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Gender {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_gender")
    private Integer idGender;
    @Column(name = "name")
    private String nameGender;


    @ManyToMany(mappedBy = "genders")
    @JsonIgnore
    private List<Serie> series;

}
