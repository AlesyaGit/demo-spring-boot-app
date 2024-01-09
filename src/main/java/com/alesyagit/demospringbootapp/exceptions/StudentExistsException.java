package com.alesyagit.demospringbootapp.exceptions;

public class StudentExistsException extends RuntimeException {

    public StudentExistsException(String message){
        super(message);
    }
}
