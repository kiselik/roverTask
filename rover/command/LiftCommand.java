package netcracker.intensive.rover.command;

import netcracker.intensive.rover.Rover;

public class LiftCommand implements RoverCommand {
    private Rover rover;

    public LiftCommand(Rover cur_rover) {
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
    @Override
    public boolean equals(Object obj) {
        return this.toString().equals(obj.toString());
    }
}
