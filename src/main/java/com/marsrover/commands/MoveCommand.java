package com.marsrover.commands;


import com.marsrover.MarsRover;

public class MoveCommand implements ICommand {

    @Override
    public void execute(final MarsRover rover) {
        rover.move();
    }

}
