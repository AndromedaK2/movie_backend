package com.usach.movie_backend.series.repository;

import com.usach.movie_backend.series.domain.Serie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ISerieRepository extends JpaRepository<Serie,Integer> {

    List<Serie> findByGenders_IdGender(Integer idGender);

    @Query(value = "     SELECT\n" +
            "       S.id_serie, S.name, S.synopsis, S.release_date,\n" +
            " \t   S.url_photo,S.trailer,S.views, S.qualification, S.id_producer,\n" +
            "\t   S.id_director, S.active\n" +
            "    FROM\n" +
            "        SERIES AS S  \n" +
            "    INNER JOIN\n" +
            "        FAVORITES_SERIES AS FS  \n" +
            "            ON S.id_serie = FS.id_serie  \n" +
            "    INNER JOIN\n" +
            "        FAVORITES AS F  \n" +
            "            ON F.id_favorite = FS.id_favorite  \n" +
            "    WHERE\n" +
            "        F.id_favorite = :idFavorite\n" +
            " ", nativeQuery = true)
    List<Serie> findFavoriteSeriesByIdFavorite(@Param("idFavorite") Integer idFavorite);

    Optional<Serie> findByName(String name);
}
