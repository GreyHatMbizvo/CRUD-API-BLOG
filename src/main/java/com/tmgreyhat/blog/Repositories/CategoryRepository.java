package com.tmgreyhat.blog.Repositories;

import com.tmgreyhat.blog.Models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {


}
