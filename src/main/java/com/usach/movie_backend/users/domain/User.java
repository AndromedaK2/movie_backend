package com.usach.movie_backend.users.domain;

import com.usach.movie_backend.profiles.domain.Profile;
import com.usach.movie_backend.roles.domain.Rol;
import com.usach.movie_backend.suscriptions.domain.Subscription;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name="users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_user")
    private Integer id;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private  String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "wallet",insertable = false)
    private Float wallet;

    @Column(name = "birthday")
    private Date birthday;

    @Column(name = "password")
    private String password;

    @Column(name ="quantity_profiles_created",insertable = false)
    private Integer quantityProfilesCreated;

    @ManyToOne
    @JoinColumn(name = "id_rol",insertable = false, updatable = false)
    private Rol rol;

    @OneToOne(cascade = CascadeType.REMOVE, orphanRemoval = true)
    @JoinColumn(name = "id_subscription", referencedColumnName = "id_subscription", updatable = false)
    private Subscription subscription;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user", cascade = CascadeType.ALL,orphanRemoval = true)
    private Set<Profile> profiles;
}
