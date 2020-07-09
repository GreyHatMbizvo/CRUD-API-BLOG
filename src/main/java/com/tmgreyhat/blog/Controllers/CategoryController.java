package com.tmgreyhat.blog.Controllers;

import com.tmgreyhat.blog.Models.Category;
import com.tmgreyhat.blog.Repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categories")
public class CategoryController {



    @Autowired
    private CategoryRepository repository;


    @GetMapping
    List<Category> getAll(){

        return  repository.findAll();
    }

    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    private Optional<Category> findOne(@PathVariable(name = "id") Long id){

        return repository.findById(id);
    }

    @PostMapping
    Category createCategory(@RequestBody Category category){

        return  repository.save(category);
    }


}
