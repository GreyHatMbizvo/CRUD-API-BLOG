package com.tmgreyhat.blog.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Data
@Entity
@Table(name = "topics")
@NoArgsConstructor
@AllArgsConstructor
public class Topic  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "topic_id")
    long id;

    String topic_title;

    String topic_desc;

    @Generated(GenerationTime.INSERT)
    java.util.Date created_on;


    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "user_id" )
    private  User user;


    @ManyToOne (fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "category_id")
    private  Category category;


    @OneToMany(mappedBy = "topic", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Post> posts;


    @JsonManagedReference(value = "topic-posts")
    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    @JsonBackReference (value = "category-topics")
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }




    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTopic_title() {
        return topic_title;
    }

    public void setTopic_title(String topic_title) {
        this.topic_title = topic_title;
    }

    public String getTopic_desc() {
        return topic_desc;
    }

    public void setTopic_desc(String topic_desc) {
        this.topic_desc = topic_desc;
    }

    public Date getCreated_on() {
        return created_on;
    }

    public void setCreated_on(Date created_on) {
        this.created_on = created_on;
    }


    @JsonBackReference(value = "user-topics")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
