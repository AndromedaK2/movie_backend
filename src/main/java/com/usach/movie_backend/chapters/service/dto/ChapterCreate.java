package com.usach.movie_backend.chapters.service.dto;

import java.util.Date;

public record ChapterCreate (String duration,
                             String sinopsys,
                             String video,
                             Date date,
                             String nameSeason,
                             Integer chapterNumber) {
}
