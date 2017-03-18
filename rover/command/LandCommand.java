package netcracker.intensive.rover.command;

import netcracker.intensive.rover.Point;
import netcracker.intensive.rover.Rover;
import netcracker.intensive.rover.constants.Direction;

public class LandCommand implements RoverCommand {
    private Rover rover;
    private Point position;
    private Direction direction;

    LandCommand(Rover cur_rover, Point cur_position, Direction cur_direction) {
        rover = cur_rover;
        position = cur_position;
        direction = cur_direction;
    }

    @Override
    public void execute() {
        rover.land(position, direction);
    }

    @Override
    public String toString() {
        return "Land at ("+position.getX()+", "+position.getY()+") heading "+direction;
    }
}
