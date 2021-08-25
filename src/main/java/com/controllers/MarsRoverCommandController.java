package com.controllers;

import com.application.marsrover.Direction;
import com.application.marsrover.MarsRover;
import com.commands.MoveCommand;
import com.commands.TurnCommand;

public class MarsRoverCommandController {

    private final String _commands;

    public MarsRoverCommandController(String commands) {
        _commands = commands;
    }

    public String runCommand(MarsRover marsRover) {

        char[] commands = _commands.toCharArray();

        for (char command : commands
        ) {
            switch (command) {
                case ('M'):
                    move(marsRover);
                    break;
                case ('L'):
                    marsRover.setOrientation(turnLeft(marsRover));
                    break;
                case ('R'):
                    marsRover.setOrientation(turnRight(marsRover));
                    break;
            }
        }

        return String.format("%d:%d:%s", marsRover.getXCoordinate(), marsRover.getYCoordinate(), marsRover.getOrientation().toString());
    }

    private void move(MarsRover marsRover) {
        new MoveCommand().move(marsRover);
    }

    private Direction turnLeft(MarsRover marsRover) {
        return new TurnCommand().left(marsRover);
    }

    private Direction turnRight(MarsRover marsRover) {
        return new TurnCommand().right(marsRover);
    }
}
