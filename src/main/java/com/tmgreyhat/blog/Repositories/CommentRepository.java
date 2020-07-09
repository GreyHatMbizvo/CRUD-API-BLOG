package com.tmgreyhat.blog.Repositories;

import com.tmgreyhat.blog.Models.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository  extends JpaRepository<Comment, Long> {


}
