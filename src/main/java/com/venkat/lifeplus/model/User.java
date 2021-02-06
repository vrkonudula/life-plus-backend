package com.venkat.lifeplus.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "users",schema = "lifeplus")
@JsonIgnoreProperties(value = "media")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "user_seq")
    @SequenceGenerator(name = "user_seq",allocationSize = 1)
    @Column(name = "user_id")
    private long userId;

    @Column(name = "email_id", nullable = false,unique = true)
    private String emailId;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "user_name", nullable = false,unique = true)
    private String userName;

    @Column(name = "dob", nullable = false)
    private Date dob;

    @CreationTimestamp
    @Column(name = "date_created")
    private Date dateCreated;

    @OneToMany(cascade = CascadeType.ALL , fetch = FetchType.LAZY, targetEntity = Media.class)
    @JoinColumn(name = "user_id")
    @OrderBy("mediaId asc")
    private List<Media> media;
}
