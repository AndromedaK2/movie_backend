package com.usach.movie_backend.favorites.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "favorites_movies")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class FavoritesMovies {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_favorite_movie")
    private Integer idFavoriteMovie;
    @Column(name = "id_favorite")
    private String idFavorite;
    @Column(name = "id_movie")
    private Integer idMovie;
}
