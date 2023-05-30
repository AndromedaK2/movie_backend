package com.usach.movie_backend.directors.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name ="directors")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Director {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_director")
    private Integer idDirector;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "birthday")
    private Date birthday;
    @Column(name = "nationality")
    private String nationality;
    @Column(name = "url_photo")
    private String urlPhoto;



}
