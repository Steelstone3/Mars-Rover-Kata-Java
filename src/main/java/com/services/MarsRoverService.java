package com.services;

import com.application.marsrover.MarsRover;
import com.controllers.MarsRoverCommandController;

public class MarsRoverService {
    public void runMarsRover(MarsRover marsRover, MarsRoverCommandController marsRoverCommandController) {
        marsRoverCommandController.runCommand(marsRover);
    }
}