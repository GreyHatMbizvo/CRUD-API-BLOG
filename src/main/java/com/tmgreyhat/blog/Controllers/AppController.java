package com.tmgreyhat.blog.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {


    @GetMapping("/")
    private  String getIndexPage(){

        return "index";
    }


    @GetMapping("/login")
    private String getLoginPage(){

        return  "login";
    }

    @GetMapping("/register")
    private String getRegisterPage(){

        return  "register";
    }





}
