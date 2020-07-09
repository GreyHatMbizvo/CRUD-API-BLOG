package com.tmgreyhat.blog.Controllers;

import com.tmgreyhat.blog.Models.Topic;
import com.tmgreyhat.blog.Repositories.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/topics")
public class TopicController {



    @Autowired
    private TopicRepository repository;


    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    List<Topic> getAll(){

        return repository.findAll();
    }

    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    private Optional<Topic> findOne(@PathVariable(name = "id") Long id){

        return repository.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    Topic addNewTopic(@RequestBody Topic topic){


        return  repository.save(topic);

    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    void delete (@PathVariable(name = "id") Long id){

        repository.deleteById(id);

    }






}
