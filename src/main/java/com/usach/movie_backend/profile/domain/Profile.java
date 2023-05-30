package com.usach.movie_backend.profile.domain;


import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name ="profiles")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Profile {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "id_profile")
    private Integer idProfile;
    @Column(name = "username")
    private String username;
    @Column(name = "url_photo")
    private String urlPhoto;
    @Column(name = "creation_date")
    private Date creationDate;
    @Column(name = "id_user")
    private Long idUser;


}
