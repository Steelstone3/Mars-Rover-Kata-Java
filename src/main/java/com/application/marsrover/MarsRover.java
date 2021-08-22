package com.application.marsrover;

import com.controllers.MarsRoverCommandController;
import com.services.MarsRoverService;

public class MarsRover {

    private int _xCoordinate = 0;
    private int _yCoordinate = 0;
    private Direction _orientation = Direction.North;

    public MarsRover(int grid[][]) {

    }

    public int getXCoordinate() {
        return _xCoordinate;
    }

    public int getYCoordinate() {
        return _yCoordinate;
    }

    public Direction getOrientation() {
        return _orientation;
    }

    public void runCommand(MarsRoverService marsRoverService, MarsRoverCommandController marsRoverCommandController) {
        marsRoverService.runMarsRover(this, marsRoverCommandController);
    }
}