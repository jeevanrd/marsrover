package com.marsrover.commands;


import com.marsrover.MarsRover;

public class RotateRightCommand implements ICommand {

    @Override
    public void execute(final MarsRover rover) {
        rover.turnRight();
    }

}
