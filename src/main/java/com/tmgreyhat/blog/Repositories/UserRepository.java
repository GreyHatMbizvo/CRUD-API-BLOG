package com.tmgreyhat.blog.Repositories;

import com.tmgreyhat.blog.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
