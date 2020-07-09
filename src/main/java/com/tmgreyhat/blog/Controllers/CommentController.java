package com.tmgreyhat.blog.Controllers;

import com.tmgreyhat.blog.Models.Comment;
import com.tmgreyhat.blog.Repositories.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/comments")
public class CommentController {


    @Autowired
    private CommentRepository repository;

    @GetMapping
    List<Comment> getAll (){

        return repository.findAll();
    }

    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    Optional<Comment> getOneCommentById(@PathVariable(name = "id") Long id){


        return repository.findById(id);

    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    Comment createComment(@RequestBody Comment comment){

        return repository.save(comment);

    }


    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    void delete(@PathVariable(name = "id") long id){

        repository.deleteById(id);
    }


}
