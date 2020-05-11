package org.cap.passengermngt.exceptions;

public class PassengerNotFoundException extends RuntimeException{
    public PassengerNotFoundException(String message){
        super(message);
    }
}
