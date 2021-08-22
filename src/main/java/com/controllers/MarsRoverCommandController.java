package com.controllers;

import com.application.marsrover.MarsRover;

public class MarsRoverCommandController {

    private String _commands;

    public MarsRoverCommandController(String commands) {
        _commands = commands;
    }

    public void runCommand(MarsRover marsRover) {
        switch (_commands)
        {
            case("M"):

            case("L"):

            case("R"):
        }
    }
}
