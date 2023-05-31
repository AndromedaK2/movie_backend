package com.usach.movie_backend.user.repository;


import com.usach.movie_backend.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.Optional;

@Repository
public interface IUserRepository extends JpaRepository<User,Integer> {

    Optional<User> findByEmail(String email);

    @Query(value = "SELECT u FROM User u WHERE LOWER(u.email) = LOWER(:email) and LOWER(u.password) = LOWER(:password)")
    Optional<User> login(@Param("email") String email, @Param("password") String password);



}
