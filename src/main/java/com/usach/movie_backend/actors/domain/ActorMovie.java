package com.usach.movie_backend.actors.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "actors_movies")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ActorMovie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_actor_movie")
    private Integer idActorMovie;
    @Column(name = "id_movie")
    private Integer idMovie;
    @Column(name = "id_actor")
    private Integer idActor;
    @Column(name = "character_name")
    private String characterName;
}
