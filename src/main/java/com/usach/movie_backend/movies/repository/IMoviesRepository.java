package com.usach.movie_backend.movies.repository;

import com.usach.movie_backend.movies.domain.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface IMoviesRepository extends JpaRepository<Movie,Integer> {

    Optional<Movie> findMovieByTitle(String title);

    void deleteByTitle(String title);

    @Query(value = "SELECT M.id_movie, M.title,M.synopsis,M.duration, M.release_date," +
            "M.url_video,M.url_photo,M.url_trailer,M.views,M.note,M.id_director," +
            "M.id_producer,M.active\n" +
            "FROM Genders as G\n" +
            "INNER JOIN Genders_Movies as GM\n" +
            "  ON GM.id_gender = G.id_gender\n" +
            "INNER JOIN Movies M\n" +
            "  ON M.id_movie = GM.id_movie\n" +
            "INNER Join Directors D\n" +
            "  ON D.id_director = M.id_director\n" +
            "INNER Join Producers P \n" +
            "  ON P.id_producer = M.id_producer\n" +
            "WHERE G.name = :genderName OR\n" +
            "  (D.first_name =:directorFirstName AND D.last_name =:directorLastName) OR\n" +
            "   P.name = :producerName",
            countQuery = "SELECT COUNT(*)" +
                    "FROM Genders as G\n" +
                    "INNER JOIN Genders_Movies as GM\n" +
                    "  ON GM.id_gender = G.id_gender\n" +
                    "INNER JOIN Movies M\n" +
                    "  ON M.id_movie = GM.id_movie\n" +
                    "INNER Join Directors D\n" +
                    "  ON D.id_director = M.id_director\n" +
                    "INNER Join Producers P \n" +
                    "  ON P.id_producer = M.id_producer\n" +
                    "WHERE G.name = :genderName OR\n" +
                    "  (D.first_name =:directorFirstName AND D.last_name =:directorLastName) OR\n" +
                    "   P.name = :producerName",
            nativeQuery = true)
    Page<Movie> findAllByFilter(@Param("genderName") String genderName, @Param("producerName") String producerName,
                              @Param("directorFirstName") String directorFirstName, @Param("directorLastName") String  directorLastName,
                              Pageable pageable);


}