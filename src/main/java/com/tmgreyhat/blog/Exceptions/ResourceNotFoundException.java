package com.tmgreyhat.blog.Exceptions;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(long id){
        super("Could not find Resource With id "+ id);

    }

}
