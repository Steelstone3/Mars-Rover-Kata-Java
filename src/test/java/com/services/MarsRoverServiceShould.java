package com.services;

import com.application.marsrover.MarsRover;
import com.controllers.MarsRoverCommandController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class MarsRoverServiceShould {

    private MarsRoverService _marsRoverService = new MarsRoverService();

    @Mock
    private MarsRover _marsRover = mock(MarsRover.class);

    @Mock
    private MarsRoverCommandController _marsRoverCommandController = mock(MarsRoverCommandController.class);

    @BeforeEach
    public void setup(){

    }

    @Test
    public void moveFromController(){
        _marsRoverService.runMarsRover(_marsRover, _marsRoverCommandController);
        verify(_marsRoverCommandController).runCommand(_marsRover);
    }

    @Test
    public void turnFromController(){
        _marsRoverService.runMarsRover(_marsRover, _marsRoverCommandController);
        verify(_marsRoverCommandController).runCommand(_marsRover);
    }
}
