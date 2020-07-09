package com.tmgreyhat.blog.Repositories;

import com.tmgreyhat.blog.Models.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
