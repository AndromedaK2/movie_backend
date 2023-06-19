package com.usach.movie_backend.profile.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name ="profiles_movies")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProfileMovie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_profile_movie")
    private  Integer idProfileMovie;
    @Column(name = "id_movie")
    private Integer idmovie;
    @Column(name = "id_profile")
    private Integer idProfile;
    @Column(name = "view_later")
    private boolean viewLater;
}
