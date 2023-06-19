package com.usach.movie_backend.profile.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name ="profiles_Series")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class ProfileSerie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_profile_serie")
    private  Integer idProfileSerie;
    @Column(name = "id_Serie")
    private Integer idSerie;
    @Column(name = "id_profile")
    private Integer idProfile;
    @Column(name = "view_later")
    private boolean viewLater;
}
