package com.usach.movie_backend.user.repository;

import com.usach.movie_backend.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Optional;

@Repository
public interface IUserRepository extends JpaRepository<User,Integer> {

    Optional<User> findByEmail(String email);

    @Query(value = "SELECT u FROM User u WHERE LOWER(u.email) = LOWER(:email) and LOWER(u.password) = LOWER(:password)")
    Optional<User> login(@Param("email") String email, @Param("password") String password);

    @Query("DELETE FROM User u WHERE u.email = :email")
    @Modifying
    @Transactional
    void deleteByEmail(@Param("email") String email);

    @Query("UPDATE User u SET u.email =?1, u.password =?2, u.firstName =?3, u.lastName =?4, u.birthday =?5, u.wallet =?6  where u.email=?1")
    @Modifying
    @Transactional
    int updateUser(String email, String password, String firstName, String lastName, Date birthday, Float wallet );

}
