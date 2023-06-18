package com.usach.movie_backend.comments.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "comments_profiles_chapters")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CommentsProfilesChapters {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_comment_chapter")
    private Integer idCommentChapter;
    @Column(name = "description")
    private String description;
    @Column(name = "note")
    private Integer note;
    @Column(name = "last_update")
    private Date lastUpdate;
    @Column(name = "creation_date")
    private Date creationDate;
    @Column(name = "id_profile")
    private Integer idProfile;
    @Column(name = "id_chapter")
    private Integer idChapter;


}
