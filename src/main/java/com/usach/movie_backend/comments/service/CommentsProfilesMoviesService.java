package com.usach.movie_backend.comments.service;

import com.usach.movie_backend.comments.domain.CommentsProfilesMovies;
import com.usach.movie_backend.comments.repository.ICommentsProfilesMoviesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentsProfilesMoviesService implements ICommentsProfilesMoviesService<CommentsProfilesMovies> {
    @Autowired
    private ICommentsProfilesMoviesRepository iCommentsProfilesMoviesRepository;

    @Override
    public List<CommentsProfilesMovies> findAll() {
        return iCommentsProfilesMoviesRepository.findAll();
    }

    @Override
    public Optional<CommentsProfilesMovies> findByCommentsProfilesMovies(Integer idCommentsProfilesMovies) {
        return iCommentsProfilesMoviesRepository.findById(idCommentsProfilesMovies);
    }

    @Override
    public CommentsProfilesMovies create(CommentsProfilesMovies commentsProfilesMovies) {
        return iCommentsProfilesMoviesRepository.save(commentsProfilesMovies);
    }

    @Override
    public CommentsProfilesMovies update(CommentsProfilesMovies commentsProfilesMovies) {
        return iCommentsProfilesMoviesRepository.save(commentsProfilesMovies);
    }

    @Override
    public void delete(Integer idCommentsProfilesMovies) {

        iCommentsProfilesMoviesRepository.deleteById(idCommentsProfilesMovies);
    }
}
