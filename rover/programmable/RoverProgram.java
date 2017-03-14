package netcracker.intensive.rover.programmable;

import java.util.HashMap;

public class RoverProgram {
    public static final String LOG = "log";
    public static final String STATS = "stats";
    public static final String SEPARATOR = "===";


    private HashMap<String, Object> config = new HashMap<>();

    HashMap<String, Object> getCongig() {
        return config;
    }
}
