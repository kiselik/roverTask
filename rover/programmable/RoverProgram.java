package netcracker.intensive.rover.programmable;

import netcracker.intensive.rover.command.RoverCommand;
import netcracker.intensive.rover.constants.Direction;

import java.util.*;

public class RoverProgram {
    public static final String LOG = "log";
    public static final String STATS = "stats";
    public static final String SEPARATOR = "===";

    private ArrayList<RoverCommand> commands = new ArrayList<>();
    private HashMap<String, Object> settings = new HashMap<>();

    void memoriseConfig(String Key, Object Value) {
        settings.put(Key, Value);
    }

    HashMap<String, Object> getSettings() {
        return settings;
    }

    void memoriseCommand(RoverCommand command) {
        commands.add(command);
    }

    Collection<RoverCommand> getCommands() {
        return commands;
    }
}
