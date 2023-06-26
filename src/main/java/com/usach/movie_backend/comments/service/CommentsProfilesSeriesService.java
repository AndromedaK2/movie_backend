package com.usach.movie_backend.comments.service;

import com.usach.movie_backend.comments.domain.CommentsProfilesSeries;
import com.usach.movie_backend.comments.repository.ICommentsProfilesSeriesRepository;
import com.usach.movie_backend.comments.service.dto.CommentProfileSerieCreate;
import com.usach.movie_backend.comments.service.dto.CommentProfileSerieUpdate;
import com.usach.movie_backend.profiles.domain.Profile;
import com.usach.movie_backend.profiles.service.IProfileService;
import com.usach.movie_backend.series.domain.Serie;
import com.usach.movie_backend.series.repository.ISerieRepository;
import com.usach.movie_backend.series.service.SerieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CommentsProfilesSeriesService implements ICommentsProfilesSeriesService {
    @Autowired
    private ICommentsProfilesSeriesRepository iCommentsProfilesSeriesRepository;
    @Autowired
    private IProfileService profileService;
    @Autowired
    private SerieService serieService;
    @Autowired
    private ISerieRepository iSerieRepository;

    @Override
    public List<CommentsProfilesSeries> findAll() {
        return iCommentsProfilesSeriesRepository.findAll();
    }

    @Override
    public CommentsProfilesSeries findByCommentsProfilesSeries(Integer idCommentsProfilesSeries) {
        return iCommentsProfilesSeriesRepository.findById(idCommentsProfilesSeries).get();
    }

    @Override
    public Double commentsSerieAVG(Integer idSerie) {
        return iCommentsProfilesSeriesRepository.commentAVGNote(idSerie);
    }



    @Transactional(noRollbackFor = {ResponseStatusException.class})
    public CommentsProfilesSeries create(CommentProfileSerieCreate CommentProfileSerieCreate) {
        Profile profile = profileService.find(CommentProfileSerieCreate.username(),CommentProfileSerieCreate.userEmail());
        Serie serie = serieService.findByName(CommentProfileSerieCreate.title());

        CommentsProfilesSeries commentsProfilesSeries = new CommentsProfilesSeries();

        commentsProfilesSeries.setIdProfile(profile.getIdProfile());
        commentsProfilesSeries.setIdSerie(serie.getIdSerie());
        commentsProfilesSeries.setDescription(CommentProfileSerieCreate.description());
        commentsProfilesSeries.setLastUpdate(new Date() );
        commentsProfilesSeries.setCreationDate(new Date());
        commentsProfilesSeries.setNote(CommentProfileSerieCreate.note());
        CommentsProfilesSeries commentsProfilesSeries1 = iCommentsProfilesSeriesRepository.saveAndFlush(commentsProfilesSeries);
        double notep = iCommentsProfilesSeriesRepository.commentAVGNote(serieService.findByName(CommentProfileSerieCreate.title()).getIdSerie());

        serie.setQualification(notep);
        iSerieRepository.save(serie);

        return commentsProfilesSeries1;

    }

    @Transactional(noRollbackFor = {ResponseStatusException.class})
    public CommentsProfilesSeries update(CommentProfileSerieUpdate commentProfileSerieUpdate) {

        profileService.find(commentProfileSerieUpdate.username(), commentProfileSerieUpdate.userEmail());
        Serie serie = serieService.findByName(commentProfileSerieUpdate.title());
        CommentsProfilesSeries commentsProfilesSeries = findByCommentsProfilesSeries(commentProfileSerieUpdate.idCommentSerie());
        commentsProfilesSeries.setDescription(commentProfileSerieUpdate.description());
        commentsProfilesSeries.setNote(commentProfileSerieUpdate.noteupdate());
        commentsProfilesSeries.setLastUpdate(new Date());
        iCommentsProfilesSeriesRepository.saveAndFlush(commentsProfilesSeries);
        double notap = iCommentsProfilesSeriesRepository.commentAVGNote(serieService.findByName(commentProfileSerieUpdate.title()).getIdSerie());
        serie.setQualification(notap);
        iSerieRepository.save(serie);


        return commentsProfilesSeries;
    }

    @Override
    public void delete(Integer idCommentsProfilesSeries) {

        iCommentsProfilesSeriesRepository.deleteById(idCommentsProfilesSeries);
    }
}
