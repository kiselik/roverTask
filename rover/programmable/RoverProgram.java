package netcracker.intensive.rover.programmable;

import netcracker.intensive.rover.command.RoverCommand;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

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

    public Object put(String key, Object value) {
        if ((key.equals(RoverProgram.LOG)) || (key.equals(RoverProgram.STATS)))
            return settings.put(key, value);
        else
            throw new UnsupportedOperationException();
    }

    //like getSettings
    public Boolean get(String Key) {
        return (boolean) settings.get(Key);
    }
}
