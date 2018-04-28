package com.marsrover.commands;


import com.marsrover.MarsRover;

public class RotateLeftCommand implements ICommand {

    @Override
    public void execute(final MarsRover rover) {
        rover.turnLeft();
    }

}
