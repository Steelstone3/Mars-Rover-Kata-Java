package com.application.marsrovertests;

import com.application.marsrover.Direction;
import com.application.marsrover.MarsRover;
import com.controllers.MarsRoverCommandController;
import com.services.MarsRoverService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class MarsRoverShould {

    private int[][] _grid;
    private MarsRover _marsRover;

    @Mock
    private MarsRoverService _marsRoverService = mock(MarsRoverService.class);

    @Mock
    private MarsRoverCommandController _marsRoverCommandController = mock(MarsRoverCommandController.class);

    @BeforeEach
    public void setup(){
        _marsRover = new MarsRover(_grid);
    }

    @Test
    public void containsCoordinates(){
        Assertions.assertEquals(0, _marsRover.getXCoordinate());
        Assertions.assertEquals(0, _marsRover.getYCoordinate());
    }

    @Test
    public void containsOrientation(){
        Assertions.assertEquals(Direction.North, _marsRover.getOrientation());
    }

    @Test
    public void moveFromService(){
        _marsRover.runCommand(_marsRoverService, _marsRoverCommandController);
        verify(_marsRoverService).runMarsRover(_marsRover, _marsRoverCommandController);
    }

    @Test
    public void turnFromService(){
        _marsRover.runCommand(_marsRoverService, _marsRoverCommandController);
        verify(_marsRoverService).runMarsRover(_marsRover, _marsRoverCommandController);
    }
}
