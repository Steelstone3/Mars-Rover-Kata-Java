package com.controllers;

import com.application.marsrover.Direction;
import com.application.marsrover.MarsRover;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.mockito.Mockito.mock;

public class MarsRoverCommandControllerShould {

    private int[][] _grid;
    private MarsRover _marsRover;
    private MarsRoverCommandController _marsRoverCommandController;

    @BeforeEach
    public void setup() {
        _grid = new int[][]{};
        _marsRover = new MarsRover(_grid);
    }

    @Test
    public void move() {
        _marsRoverCommandController = new MarsRoverCommandController("M");

        _marsRoverCommandController.runCommand(_marsRover);

        Assertions.assertEquals(0, _marsRover.getXCoordinate());
        Assertions.assertEquals(1, _marsRover.getYCoordinate());
    }

    @Test
    public void turnLeft() {
        _marsRoverCommandController = new MarsRoverCommandController("L");

        _marsRoverCommandController.runCommand(_marsRover);

        Assertions.assertEquals(Direction.West, _marsRover.getOrientation());
    }

    @Test
    public void turnRight() {
        _marsRoverCommandController = new MarsRoverCommandController("R");

        _marsRoverCommandController.runCommand(_marsRover);

        Assertions.assertEquals(Direction.East, _marsRover.getOrientation());
    }
}
