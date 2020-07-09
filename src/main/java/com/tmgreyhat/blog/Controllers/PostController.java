package com.tmgreyhat.blog.Controllers;

import com.tmgreyhat.blog.Models.Post;
import com.tmgreyhat.blog.Repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    private PostRepository repository;


    @GetMapping
    List<Post> getAllPosts(){

        return  repository.findAll();
    }


    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    Optional<Post> getOneById(@PathVariable(name = "id") Long id){

        return repository.findById(id);
    }

    @PostMapping
    Post createPost(@RequestBody Post post){

        return  repository.save(post);
    }




}
