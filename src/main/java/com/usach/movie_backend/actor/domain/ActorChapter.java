package com.usach.movie_backend.actor.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "actors_chapters")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ActorChapter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_actor_chapter")
    private Integer idActorChapter;
    @Column(name = "id_chapter")
    private Integer idChapter;
    @Column(name = "id_actor")
    private Integer idActor;
    @Column(name = "character_name")
    private String characterName;
}
