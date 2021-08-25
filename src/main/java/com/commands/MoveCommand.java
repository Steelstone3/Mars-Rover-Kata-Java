package com.commands;

import com.application.marsrover.MarsRover;

public class MoveCommand {
    public void move(MarsRover marsRover) {
        switch (marsRover.getOrientation())
        {
            case North:
                north(marsRover);
                break;
            case East:
                east(marsRover);
                break;
            case South:
                south(marsRover);
                break;
            case West:
                west(marsRover);
                break;
            default:
                break;
        }
    }

    private void north(MarsRover marsRover) {
        marsRover.setYCoordinate(marsRover.getYCoordinate() + 1);

        if(marsRover.getYCoordinate() > 9) {
            marsRover.setYCoordinate(0);
        }
    }

    private void east(MarsRover marsRover) {
        marsRover.setXCoordinate(marsRover.getXCoordinate() + 1);

        if(marsRover.getXCoordinate() > 9) {
            marsRover.setXCoordinate(0);
        }
    }

    private void south(MarsRover marsRover) {
        marsRover.setYCoordinate(marsRover.getYCoordinate() - 1);

        if(marsRover.getYCoordinate() < 0) {
            marsRover.setYCoordinate(9);
        }
    }

    private void west(MarsRover marsRover) {
        marsRover.setXCoordinate(marsRover.getXCoordinate() - 1);

        if(marsRover.getXCoordinate() < 0) {
            marsRover.setXCoordinate(9);
        }
    }
}
