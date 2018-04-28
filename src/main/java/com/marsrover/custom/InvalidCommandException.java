package com.marsrover.custom;


public class InvalidCommandException extends RuntimeException {
    public InvalidCommandException() {
        super("This is a invalid command");
    }
}
