package com.commands;

import com.application.marsrover.Direction;
import com.application.marsrover.MarsRover;

import static com.application.marsrover.Direction.*;
import static com.application.marsrover.Direction.North;

public class TurnCommand {
    public Direction left(MarsRover marsRover) {
        switch (marsRover.getOrientation())
        {
            case North:
                return West;
            case West:
                return South;
            case South:
                return East;
            case East:
                return North;
        }

        return null;
    }

    public Direction right(MarsRover marsRover) {
        switch (marsRover.getOrientation())
        {
            case North:
                return East;
            case East:
                return South;
            case South:
                return West;
            case West:
                return North;
        }

        return null;
    }
}
