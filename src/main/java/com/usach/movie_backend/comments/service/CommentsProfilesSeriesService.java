package com.usach.movie_backend.comments.service;

import com.usach.movie_backend.comments.domain.CommentsProfilesSeries;
import com.usach.movie_backend.comments.repository.ICommentsProfilesSeriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentsProfilesSeriesService implements ICommentsProfilesSeriesService<CommentsProfilesSeries> {
    @Autowired
    private ICommentsProfilesSeriesRepository iCommentsProfilesSeriesRepository;

    @Override
    public List<CommentsProfilesSeries> findAll() {
        return iCommentsProfilesSeriesRepository.findAll();
    }

    @Override
    public Optional<CommentsProfilesSeries> findByCommentsProfilesSeries(Integer idCommentsProfilesSeries) {
        return iCommentsProfilesSeriesRepository.findById(idCommentsProfilesSeries);
    }

    @Override
    public CommentsProfilesSeries create(CommentsProfilesSeries commentsProfilesSeries) {
        return iCommentsProfilesSeriesRepository.save(commentsProfilesSeries);
    }

    @Override
    public CommentsProfilesSeries update(CommentsProfilesSeries commentsProfilesSeries) {
        return iCommentsProfilesSeriesRepository.save(commentsProfilesSeries);
    }

    @Override
    public void delete(Integer idCommentsProfilesSeries) {

        iCommentsProfilesSeriesRepository.deleteById(idCommentsProfilesSeries);
    }
}
