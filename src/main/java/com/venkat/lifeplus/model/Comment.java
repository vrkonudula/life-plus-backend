package com.venkat.lifeplus.model;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "comments", schema = "lifeplus")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "comment_seq")
    @SequenceGenerator(name = "comment_seq",allocationSize = 1)
    @Column(name = "comment_id")
    private long commentId;

    @Column(name = "user_name", nullable = false)
    private String userName;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "date_created")
    @CreationTimestamp
    private Date dateCreated;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "media_id")
    private Media media;
}
