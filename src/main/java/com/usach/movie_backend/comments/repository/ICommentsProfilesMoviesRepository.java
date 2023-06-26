package com.usach.movie_backend.comments.repository;

import com.usach.movie_backend.comments.domain.CommentsProfilesMovies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ICommentsProfilesMoviesRepository extends JpaRepository<CommentsProfilesMovies,Integer> {
    List<CommentsProfilesMovies> findAll();


    @Query(value = "select sum(note) from comments_profiles_movies where id_movie = :idMovie",nativeQuery = true)
    Double sumCommentsMovie(@Param("idMovie") Integer idMovie);
    @Query(value = "select count(id_movie) from comments_profiles_movies where id_movie = :idMovie", nativeQuery = true)
    Double numberComments(@Param("idMovie") Integer idMovie);

    @Query(value = "select AVG(note) from comments_profiles_movies where id_movie = :idMovie", nativeQuery = true)
    Double commentAVGNote(@Param("idMovie") Integer idMovie);
}
