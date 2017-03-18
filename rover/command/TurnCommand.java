package netcracker.intensive.rover.command;

import netcracker.intensive.rover.Rover;
import netcracker.intensive.rover.constants.Direction;

public class TurnCommand implements RoverCommand {
    private Rover rover;
    private Direction direction;

    TurnCommand(Rover cur_rover, Direction cur_direction) {
        rover = cur_rover;
        direction = cur_direction;
    }

    @Override
    public void execute() {
        rover.turnTo(direction);
    }

    @Override
    public String toString() {
        return "Heading "+direction;
    }
}
