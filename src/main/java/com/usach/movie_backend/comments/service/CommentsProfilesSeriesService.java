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

@Service
public class CommentsProfilesSeriesService implements ICommentsProfilesSeriesService {
    @Autowired
    private ICommentsProfilesSeriesRepository commentsProfilesSeriesRepository;
    @Autowired
    private IProfileService profileService;
    @Autowired
    private SerieService serieService;
    @Autowired
    private ISerieRepository serieRepository;

    @Transactional(readOnly = true)
    public List<CommentsProfilesSeries> findAll() {
        return commentsProfilesSeriesRepository.findAll();
    }

    @Transactional(readOnly = true)
    public CommentsProfilesSeries findByCommentsProfilesSeries(Integer idCommentsProfilesSeries) {
        return commentsProfilesSeriesRepository.findById(idCommentsProfilesSeries).get();
    }

    @Transactional(readOnly = true)
    public Double commentsSerieAVG(Integer idSerie) {
        return commentsProfilesSeriesRepository.commentAVGNote(idSerie);
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
        CommentsProfilesSeries commentsProfilesSeries1 = commentsProfilesSeriesRepository.saveAndFlush(commentsProfilesSeries);
        double noteSerie = commentsProfilesSeriesRepository.commentAVGNote(serieService.findByName(CommentProfileSerieCreate.title()).getIdSerie());

        serie.setQualification(noteSerie);
        serieRepository.save(serie);

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
        commentsProfilesSeriesRepository.saveAndFlush(commentsProfilesSeries);
        double noteSerie = commentsProfilesSeriesRepository.commentAVGNote(serieService.findByName(commentProfileSerieUpdate.title()).getIdSerie());
        serie.setQualification(noteSerie);
        serieRepository.save(serie);


        return commentsProfilesSeries;
    }

    @Override
    public void delete(Integer idCommentsProfilesSeries) {

        commentsProfilesSeriesRepository.deleteById(idCommentsProfilesSeries);
    }
}
