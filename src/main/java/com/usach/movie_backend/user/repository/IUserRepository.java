package com.usach.movie_backend.user.repository;


import com.usach.movie_backend.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface IUserRepository extends JpaRepository<User,String> {

    User findByUsername(String username);

}
