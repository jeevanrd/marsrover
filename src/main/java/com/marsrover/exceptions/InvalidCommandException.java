package com.marsrover.exceptions;


public class InvalidCommandException extends RuntimeException {
    public InvalidCommandException() {
        super("This is a invalid command");
    }
}
