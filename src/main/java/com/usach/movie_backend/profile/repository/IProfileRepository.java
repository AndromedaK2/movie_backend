package com.usach.movie_backend.profile.repository;



import com.usach.movie_backend.profile.domain.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IProfileRepository extends JpaRepository<Profile, Integer> {

    List<Profile> findAll();

    @Query("DELETE FROM Profile p WHERE p.idProfile =:id")
    @Modifying
    void deleteByIdProfile(@Param("id") Integer id);

}
