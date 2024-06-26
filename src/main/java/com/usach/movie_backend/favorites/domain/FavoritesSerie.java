package com.usach.movie_backend.favorites.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "favorites_series")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class FavoritesSerie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_favorite_serie")
    private Integer idFavoriteSerie;
    @Column(name = "id_favorite")
    private Integer idFavorite;
    @Column(name = "id_serie")
    private Integer idSerie;
}
