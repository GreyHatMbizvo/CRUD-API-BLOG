package com.tmgreyhat.blog.Exceptions;

import org.springframework.data.rest.webmvc.ResourceNotFoundException;

public class Precogs {

    public static <T> T checkFound(T resource) {
        if (resource == null) {
            throw new ResourceNotFoundException();
        }
        return resource;
    }

}
