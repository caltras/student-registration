package com.claudio.school.registration.exception;


public class NotFoundData extends Exception{

    public NotFoundData(String message){
        super("Data Not Found: " + message);
    }
    
}
