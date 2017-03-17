package netcracker.intensive.rover.command;

import netcracker.intensive.rover.Rover;

public class MoveCommand implements RoverCommand {
    private Rover rover;

    MoveCommand(Rover cur_rover) {
        rover = cur_rover;
    }

    @Override
    public void execute() {
        rover.move();
    }
}
