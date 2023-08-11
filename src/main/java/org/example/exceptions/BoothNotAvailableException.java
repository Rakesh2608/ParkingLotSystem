package org.example.exceptions;

public class BoothNotAvailableException extends Exception{
    public BoothNotAvailableException(){
        super("Booth not available.");
    }
}
