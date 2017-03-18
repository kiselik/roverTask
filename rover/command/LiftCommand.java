package netcracker.intensive.rover.command;

import netcracker.intensive.rover.Rover;

public class LiftCommand implements RoverCommand {
    private Rover rover;

    LiftCommand(Rover cur_rover) {
        rover = cur_rover;
    }

    @Override
    public void execute() {
        rover.lift();
    }

    @Override
    public String toString() {
        return "Rover lifted";
    }
}
