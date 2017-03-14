package netcracker.intensive.rover.programmable;

import java.util.HashMap;

public class RoverProgram {
    public static final String LOG = "log";
    public static final String STATS = "stats";
    public static final String SEPARATOR = "===";
    public static final String TURN = "turn";
    public static final String MOVE= "move";
    public static final String LIFT = "lift";
    public static final String LAND = "land";


    private HashMap<String, Object> config = new HashMap<>();

    void memoriseConfig(String Key, Object Value){
        config.put(Key,Value);

    }
    HashMap<String, Object> getConfig() {
        return config;
    }
}
