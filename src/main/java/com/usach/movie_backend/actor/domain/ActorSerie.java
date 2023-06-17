package com.usach.movie_backend.actor.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "actors_series")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ActorSerie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_actor_serie")
    private Integer idActorSerie;
    @Column(name = "id_serie")
    private Integer idSerie;
    @Column(name = "id_actor")
    private Integer idActor;
    @Column(name = "character_name")
    private String characterName;
}
