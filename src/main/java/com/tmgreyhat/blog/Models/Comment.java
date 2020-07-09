package com.tmgreyhat.blog.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "comments")
public class Comment {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private long id ;

    private  String comment;

    @Generated(GenerationTime.INSERT)
    private Date created_on;


    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "user_id" )
    private  User user;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "post_id")
    private Post post;


    @JsonBackReference(value = "user-comments")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @JsonBackReference(value = "post-comments")
    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }
}


