package com.usach.movie_backend.user.domain;

import com.usach.movie_backend.rol.domain.Rol;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name="users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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

    @Column(name = "wallet")
    private Float wallet;

    @Column(name = "birthday")
    private Date birthday;

    @Column(name = "password")
    private String password;

    @Column(name ="quantity_profiles_created")
    private Integer quantityProfilesCreated;

    @ManyToOne
    @JoinColumn(name = "id_rol")
    private Rol rol;

    //@ManyToOne
    //@JoinColumn(name = "id_subscription")
    //private  Subscription subscription;
}
