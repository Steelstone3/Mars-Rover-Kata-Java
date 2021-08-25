package com.controllers;

import com.application.marsrover.Direction;
import com.application.marsrover.MarsRover;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MarsRoverCommandControllerShould {

    private int[][] _grid;
    private MarsRover _marsRover;
    private MarsRoverCommandController _marsRoverCommandController;

    @BeforeEach
    public void setup() {
        _grid = new int[][]{};
        _marsRover = new MarsRover(_grid);
        _marsRover.setOrientation(Direction.North);
        _marsRover.setXCoordinate(0);
        _marsRover.setYCoordinate(0);
    }

    @Test
    public void moveYOnce() {
        _marsRoverCommandController = new MarsRoverCommandController("M");

        String result = _marsRoverCommandController.runCommand(_marsRover);

        Assertions.assertEquals("0:1:North", result);
        Assertions.assertEquals(0, _marsRover.getXCoordinate());
        Assertions.assertEquals(1, _marsRover.getYCoordinate());
    }

    @Test
    public void moveYMoreThanOnce() {
        _marsRoverCommandController = new MarsRoverCommandController("MMMMM");

        String result = _marsRoverCommandController.runCommand(_marsRover);

        Assertions.assertEquals("0:5:North", result);
        Assertions.assertEquals(0, _marsRover.getXCoordinate());
        Assertions.assertEquals(5, _marsRover.getYCoordinate());
    }

    @Test
    public void moveXOnce() {
        _marsRover.setOrientation(Direction.East);
        _marsRoverCommandController = new MarsRoverCommandController("M");

        String result = _marsRoverCommandController.runCommand(_marsRover);

        Assertions.assertEquals("1:0:East", result);
        Assertions.assertEquals(1, _marsRover.getXCoordinate());
        Assertions.assertEquals(0, _marsRover.getYCoordinate());
    }

    @Test
    public void moveXMoreThanOnce() {
        _marsRover.setOrientation(Direction.East);
        _marsRoverCommandController = new MarsRoverCommandController("MMMMM");

        String result = _marsRoverCommandController.runCommand(_marsRover);

        Assertions.assertEquals("5:0:East", result);
        Assertions.assertEquals(5, _marsRover.getXCoordinate());
        Assertions.assertEquals(0, _marsRover.getYCoordinate());
    }

    @Test
    public void turnLeftOnce() {
        _marsRoverCommandController = new MarsRoverCommandController("L");

        String result = _marsRoverCommandController.runCommand(_marsRover);

        Assertions.assertEquals("0:0:West", result);
        Assertions.assertEquals(Direction.West, _marsRover.getOrientation());
    }

    @Test
    public void turnLeftMoreThanOnce() {
        _marsRoverCommandController = new MarsRoverCommandController("LLL");

        String result = _marsRoverCommandController.runCommand(_marsRover);

        Assertions.assertEquals("0:0:East", result);
        Assertions.assertEquals(Direction.East, _marsRover.getOrientation());
    }

    @Test
    public void turnRightOnce() {
        _marsRoverCommandController = new MarsRoverCommandController("R");

        String result = _marsRoverCommandController.runCommand(_marsRover);

        Assertions.assertEquals("0:0:East", result);
        Assertions.assertEquals(Direction.East, _marsRover.getOrientation());
    }

    @Test
    public void turnRightMoreThanOnce() {
        _marsRoverCommandController = new MarsRoverCommandController("RRR");

        String result = _marsRoverCommandController.runCommand(_marsRover);

        Assertions.assertEquals("0:0:West", result);
        Assertions.assertEquals(Direction.West, _marsRover.getOrientation());
    }

    @Test
    public void wrapAtNorthernBoundary() {
        _marsRover.setOrientation(Direction.North);
        _marsRoverCommandController = new MarsRoverCommandController("MMMMMMMMMMM");

        String result = _marsRoverCommandController.runCommand(_marsRover);

        Assertions.assertEquals("0:1:North", result);
        Assertions.assertEquals(0, _marsRover.getXCoordinate());
        Assertions.assertEquals(1, _marsRover.getYCoordinate());
    }

    @Test
    public void wrapAtEasternBoundary() {
        _marsRover.setOrientation(Direction.East);
        _marsRoverCommandController = new MarsRoverCommandController("MMMMMMMMMMM");

        String result = _marsRoverCommandController.runCommand(_marsRover);

        Assertions.assertEquals("1:0:East", result);
        Assertions.assertEquals(1, _marsRover.getXCoordinate());
        Assertions.assertEquals(0, _marsRover.getYCoordinate());
    }

    @Test
    public void wrapAtSouthernBoundary() {
        _marsRover.setOrientation(Direction.South);
        _marsRoverCommandController = new MarsRoverCommandController("M");

        String result = _marsRoverCommandController.runCommand(_marsRover);

        Assertions.assertEquals("0:9:South", result);
        Assertions.assertEquals(0, _marsRover.getXCoordinate());
        Assertions.assertEquals(9, _marsRover.getYCoordinate());
    }

    @Test
    public void wrapAtWesternBoundary() {
        _marsRover.setOrientation(Direction.West);
        _marsRoverCommandController = new MarsRoverCommandController("M");

        String result = _marsRoverCommandController.runCommand(_marsRover);

        Assertions.assertEquals("9:0:West", result);
        Assertions.assertEquals(9, _marsRover.getXCoordinate());
        Assertions.assertEquals(0, _marsRover.getYCoordinate());
    }

    @Test
    public void acceptVariousMoveAndTurnCommands() {
        _marsRoverCommandController = new MarsRoverCommandController("LLMMRRMMRMRM");

        _marsRoverCommandController.runCommand(_marsRover);

        Assertions.assertEquals(Direction.South, _marsRover.getOrientation());
        Assertions.assertEquals(1, _marsRover.getXCoordinate());
        Assertions.assertEquals(9, _marsRover.getYCoordinate());
    }
}
