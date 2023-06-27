package com.usach.movie_backend.users.repository;

import com.usach.movie_backend.users.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.Optional;

@Repository
public interface IUserRepository extends JpaRepository<User,Integer> {

    Optional<User> findUserByEmail(String email);

    @Query(value = "SELECT u FROM User u WHERE LOWER(u.email) = LOWER(:email) and LOWER(u.password) = LOWER(:password)")
    Optional<User> login(@Param("email") String email, @Param("password") String password);

    @Query("DELETE FROM User u WHERE u.email = :email")
    @Modifying
    void deleteByEmail(@Param("email") String email);

    @Query("UPDATE User u SET u.email =:email, u.password =:password, u.firstName =:firstName, u.lastName =:lastName, " +
            "u.birthday =:birthday, u.wallet =:wallet  WHERE LOWER(u.email) = LOWER(:email)")
    @Modifying
    int updateUser(@Param("email") String email,@Param("password")  String password,@Param("firstName") String firstName,
                    @Param("lastName")String lastName,@Param("birthday")  Date birthday,@Param("wallet")  Float wallet );


    @Query("UPDATE User u SET u.subscription.idSubscription =:idSubscription WHERE LOWER(u.email) = LOWER(:email)")
    @Modifying
    int updateUserSubscriptionId(@Param("email") String email, @Param("idSubscription") Integer idSubscription);


}
