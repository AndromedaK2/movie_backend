package com.usach.movie_backend.genders.domain;


import jakarta.persistence.*;
import lombok.*;

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

}
