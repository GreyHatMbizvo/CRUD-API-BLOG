package com.tmgreyhat.blog.Repositories;

import com.tmgreyhat.blog.Models.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TopicRepository extends JpaRepository<Topic, Long> {



    @Query(value = "select  *  from topics inner  join  users u on topics.user_id = u.user_id", nativeQuery = true)
    List<Topic> findAll();

}
