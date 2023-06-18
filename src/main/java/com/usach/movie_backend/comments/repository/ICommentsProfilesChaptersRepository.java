package com.usach.movie_backend.comments.repository;

import com.usach.movie_backend.comments.domain.CommentsProfilesChapters;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ICommentsProfilesChaptersRepository extends JpaRepository<CommentsProfilesChapters,Integer> {
List<CommentsProfilesChapters> findAll();
}
