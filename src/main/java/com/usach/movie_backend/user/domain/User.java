package com.usach.movie_backend.user.domain;

import com.usach.movie_backend.rol.domain.Rol;
import com.usach.movie_backend.suscription.domain.Subscription;
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

    @Column(name = "wallet",insertable = false)
    private Float wallet;

    @Column(name = "birthday")
    private Date birthday;

    @Column(name = "password")
    private String password;

    @Column(name ="quantity_profiles_created",insertable = false)
    private Integer quantityProfilesCreated;

    @ManyToOne
    @JoinColumn(name = "id_rol",insertable = false)
    private Rol rol;

    @OneToOne
    @JoinColumn(name = "id_subscription", referencedColumnName = "id_subscription")
    private Subscription subscription;
}
