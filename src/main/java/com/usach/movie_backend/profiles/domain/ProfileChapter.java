package com.usach.movie_backend.profiles.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name ="profiles_chapters")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProfileChapter {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "id_profiles_chapters")
    private  Integer idProfileChapter;
    @Column(name = "id_chapter")
    private Integer idChapter;
    @Column(name = "id_profile")
    private Integer idProfile;
}
