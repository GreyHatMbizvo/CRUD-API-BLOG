package com.tmgreyhat.blog.Controllers;


import com.tmgreyhat.blog.Exceptions.Precogs;
import com.tmgreyhat.blog.Exceptions.ResourceNotFoundException;
import com.tmgreyhat.blog.Models.User;
import com.tmgreyhat.blog.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {


    @Autowired
    private UserRepository repository;

    @GetMapping
    private List<User> getAllUser(){

        return  repository.findAll();
    }

    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    private User findOne(@PathVariable("id") Long id){


        return  repository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException(id));

    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private User saveUser(@RequestBody User user){

        return  repository.save(user);
    }


    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    private User update(@PathVariable("id") Long id , @RequestBody User user){

        return  repository.findById(id)
                .map(user1 -> {

                    user1.setAddress(user.getAddress());
                    user1.setEmail(user.getEmail());
                    user1.setFirst_name(user.getFirst_name());
                    user1.setLast_name(user.getLast_name());
                    user1.setPassword(user.getPassword());
                    return  repository.save(user);
                })
                .orElseThrow(()->new ResourceNotFoundException(id));




    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    private void deleteONe(@PathVariable(name = "id") Long id){

          repository.findById(id);


    }



}
