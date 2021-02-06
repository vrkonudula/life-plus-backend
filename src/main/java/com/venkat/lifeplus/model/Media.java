package com.venkat.lifeplus.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "media",schema = "lifeplus")
@JsonIgnoreProperties(value = "comments")
public class Media {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "media_seq")
    @SequenceGenerator(name = "media_seq",allocationSize = 1)
    @Column(name = "media_id")
    private long mediaId;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "type", nullable = false)
    private String type;

    @Column(name = "url", nullable = false, unique = true)
    private String url;

    @Column(name = "date_created")
    @CreationTimestamp
    private Date dateCreated;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(cascade = CascadeType.ALL , fetch = FetchType.LAZY, targetEntity = Comment.class)
    @JoinColumn(name = "media_id")
    @OrderBy("commentId asc")
    private List<Comment> comments;

}
