package com.usach.movie_backend.favorites.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "favorites")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Favorite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_favorite")
    private Integer idFavorite;
    @Column(name = "name")
    private String name;
    @Column(name = "id_profile")
    private Integer idProfile;
}
