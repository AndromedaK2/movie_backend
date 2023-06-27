package com.usach.movie_backend.comments.service;

import com.usach.movie_backend.comments.domain.CommentsProfilesMovies;
import com.usach.movie_backend.comments.repository.ICommentsProfilesMoviesRepository;
import com.usach.movie_backend.comments.service.dto.CommentProfileMovieCreate;
import com.usach.movie_backend.comments.service.dto.CommentProfileMovieUpdate;
import com.usach.movie_backend.movies.domain.Movie;
import com.usach.movie_backend.movies.repository.IMoviesRepository;
import com.usach.movie_backend.movies.service.IMoviesService;
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
    private ICommentsProfilesMoviesRepository commentsProfilesMoviesRepository;

    @Autowired
    private IProfileService profileService;

    @Autowired
    private IMoviesService moviesService;
    @Autowired
    private IMoviesRepository moviesRepository;

    @Transactional(readOnly = true)
    public List<CommentsProfilesMovies> findAll() {
        return commentsProfilesMoviesRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Double sumCommentsMovie(Integer idMovie) {
        return commentsProfilesMoviesRepository.sumCommentsMovie(idMovie);
    }

    @Transactional(readOnly = true)
    public Double numberComments(Integer idMovie) {
        return  commentsProfilesMoviesRepository.numberComments(idMovie);
    }

    @Override
    public Double commentsAVGNote(Integer idMovie) {
        return commentsProfilesMoviesRepository.commentAVGNote(idMovie);
    }

    @Transactional(readOnly = true)
    public CommentsProfilesMovies findByCommentsProfilesMovies(Integer idCommentsProfilesMovies) {
       Optional<CommentsProfilesMovies> commentsProfilesMovies =  commentsProfilesMoviesRepository.findById(idCommentsProfilesMovies);
        if(commentsProfilesMovies.isPresent())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Comment not found");
        return commentsProfilesMoviesRepository.findById(idCommentsProfilesMovies).get();
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
        commentsProfilesMovies.setNote(commentProfileMovieCreate.noteCreate());
        CommentsProfilesMovies commentsProfilesMovies1 = commentsProfilesMoviesRepository.saveAndFlush(commentsProfilesMovies);

        double notaV = commentsProfilesMoviesRepository.commentAVGNote( moviesService.findByTitle(commentProfileMovieCreate.title()).getIdMovie());
        movie.setNote(notaV);
        moviesRepository.save(movie);

        return commentsProfilesMovies1;
    }



    @Transactional(noRollbackFor = {ResponseStatusException.class})
    public CommentsProfilesMovies update(CommentProfileMovieUpdate commentProfileMovieUpdate) {

        profileService.find(commentProfileMovieUpdate.username(), commentProfileMovieUpdate.userEmail());
        Movie movie = moviesService.findByTitle(commentProfileMovieUpdate.title());
        CommentsProfilesMovies commentsProfilesMovies = findByCommentsProfilesMovies(commentProfileMovieUpdate.idComment());

        commentsProfilesMovies.setNote(commentProfileMovieUpdate.noteUpdate());
        commentsProfilesMovies.setDescription(commentProfileMovieUpdate.description());

        commentsProfilesMovies.setLastUpdate(new Date());
        commentsProfilesMoviesRepository.save(commentsProfilesMovies);
        double movieNote = commentsProfilesMoviesRepository.commentAVGNote( moviesService.findByTitle(commentProfileMovieUpdate.title()).getIdMovie());
        movie.setNote(movieNote);
        moviesRepository.save(movie);

        return commentsProfilesMovies;
    }

    @Transactional(noRollbackFor = {ResponseStatusException.class})
    public void delete(Integer idCommentsProfilesMovies) {

        commentsProfilesMoviesRepository.deleteById(idCommentsProfilesMovies);
    }
}
