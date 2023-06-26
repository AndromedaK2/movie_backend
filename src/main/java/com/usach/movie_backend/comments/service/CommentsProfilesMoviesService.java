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
    @Autowired
    private IMoviesRepository iMoviesRepository;

    @Transactional(readOnly = true)
    public List<CommentsProfilesMovies> findAll() {
        return iCommentsProfilesMoviesRepository.findAll();
    }

    @Override
    public Double sumCommentsMovie(Integer idMovie) {
        return iCommentsProfilesMoviesRepository.sumCommentsMovie(idMovie);
    }

    @Override
    public Double numberComments(Integer idMovie) {

        return  iCommentsProfilesMoviesRepository.numberComments(idMovie);
    }

    @Override
    public Double commentsAVGNote(Integer idMovie) {
        return iCommentsProfilesMoviesRepository.commentAVGNote(idMovie);
    }

    @Transactional(readOnly = true)
    public CommentsProfilesMovies findByCommentsProfilesMovies(Integer idCommentsProfilesMovies) {
       //Optional<CommentsProfilesMovies> commentsProfilesMovies =  iCommentsProfilesMoviesRepository.findById(idCommentsProfilesMovies);
        //if(commentsProfilesMovies.isPresent())
         //   throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Comment not found");
        return iCommentsProfilesMoviesRepository.findById(idCommentsProfilesMovies).get();
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
        CommentsProfilesMovies commentsProfilesMovies1 = iCommentsProfilesMoviesRepository.saveAndFlush(commentsProfilesMovies);

        double notaV = iCommentsProfilesMoviesRepository.commentAVGNote( moviesService.findByTitle(commentProfileMovieCreate.title()).getIdMovie());
        movie.setNote(notaV);
        iMoviesRepository.save(movie);

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
        iCommentsProfilesMoviesRepository.save(commentsProfilesMovies);
        double notaV = iCommentsProfilesMoviesRepository.commentAVGNote( moviesService.findByTitle(commentProfileMovieUpdate.title()).getIdMovie());
        movie.setNote(notaV);
        iMoviesRepository.save(movie);






        return commentsProfilesMovies;
    }

    @Override
    public void delete(Integer idCommentsProfilesMovies) {

        iCommentsProfilesMoviesRepository.deleteById(idCommentsProfilesMovies);
    }
}
