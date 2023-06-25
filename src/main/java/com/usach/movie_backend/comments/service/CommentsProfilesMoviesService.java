package com.usach.movie_backend.comments.service;

import com.usach.movie_backend.comments.domain.CommentsProfilesMovies;
import com.usach.movie_backend.comments.repository.ICommentsProfilesMoviesRepository;
import com.usach.movie_backend.comments.service.dto.CommentProfileMovieCreate;
import com.usach.movie_backend.comments.service.dto.CommentProfileMovieUpdate;
import com.usach.movie_backend.movies.domain.Movie;
import com.usach.movie_backend.movies.service.IMoviesService;
import com.usach.movie_backend.movies.service.dto.MovieUpdate;
import com.usach.movie_backend.profiles.domain.Profile;
import com.usach.movie_backend.profiles.service.IProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CommentsProfilesMoviesService implements ICommentsProfilesMoviesService {
    @Autowired
    private ICommentsProfilesMoviesRepository iCommentsProfilesMoviesRepository;

    @Autowired
    private IProfileService profileService;

    @Autowired
    private IMoviesService moviesService;

    @Transactional(readOnly = true)
    public List<CommentsProfilesMovies> findAll() {
        return iCommentsProfilesMoviesRepository.findAll();
    }

    @Transactional(readOnly = true)
    public CommentsProfilesMovies findByCommentsProfilesMovies(Integer idCommentsProfilesMovies) {
       Optional<CommentsProfilesMovies> commentsProfilesMovies =  iCommentsProfilesMoviesRepository.findById(idCommentsProfilesMovies);
        if(commentsProfilesMovies.isPresent())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Comment not found");
        return commentsProfilesMovies.get();
    }

    @Transactional(noRollbackFor = {ResponseStatusException.class})
    public CommentsProfilesMovies create(CommentProfileMovieCreate commentProfileMovieCreate) {

        Profile profile = profileService.find(commentProfileMovieCreate.username(), commentProfileMovieCreate.userEmail());
        Movie movie = moviesService.findByTitle(commentProfileMovieCreate.title());

        CommentsProfilesMovies commentsProfilesMovies = new CommentsProfilesMovies();
        commentsProfilesMovies.setIdProfile(profile.getIdProfile());
        commentsProfilesMovies.setIdMovie(movie.getIdMovie());
        commentsProfilesMovies.setDescription(commentProfileMovieCreate.description());
        commentsProfilesMovies.setCreationDate(new Date());
        commentsProfilesMovies.setLastUpdate(new Date());

        // promedio de las notas


        return iCommentsProfilesMoviesRepository.save(commentsProfilesMovies);
    }

    @Transactional(noRollbackFor = {ResponseStatusException.class})
    public CommentsProfilesMovies update(CommentProfileMovieUpdate commentProfileMovieUpdate) {

        profileService.find(commentProfileMovieUpdate.username(), commentProfileMovieUpdate.userEmail());
        Movie movie = moviesService.findByTitle(commentProfileMovieUpdate.title());
        CommentsProfilesMovies commentsProfilesMovies = findByCommentsProfilesMovies(commentProfileMovieUpdate.idComment());

        commentsProfilesMovies.setNote(commentsProfilesMovies.getNote());
        commentsProfilesMovies.setDescription(commentProfileMovieUpdate.description());
        commentsProfilesMovies.setLastUpdate(new Date());

        CommentsProfilesMovies commentsProfilesMovies1 = iCommentsProfilesMoviesRepository.save(commentsProfilesMovies);


        // recalculate promedio

       // MovieUpdate movieUpdate = new MovieUpdate();
       // moviesService.update(movieUpdate);

        return commentsProfilesMovies1;
    }

    @Override
    public void delete(Integer idCommentsProfilesMovies) {

        iCommentsProfilesMoviesRepository.deleteById(idCommentsProfilesMovies);
    }
}
