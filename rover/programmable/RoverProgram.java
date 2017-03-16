package netcracker.intensive.rover.programmable;

import java.util.ArrayList;
import java.util.HashMap;

public class RoverProgram {
    public static final String LOG = "log";
    public static final String STATS = "stats";
    public static final String SEPARATOR = "===";
    public static final String TURN = "turn";
    public static final String MOVE= "move";
    public static final String LIFT = "lift";
    public static final String LAND = "land";

    private ArrayList<RoverProgram> commands=new ArrayList();
    private HashMap<String, Object> configs = new HashMap<>();

    void memoriseConfig(String Key, Object Value){
        configs.put(Key,Value);
    }

    boolean getConfig(String Key){
        return (boolean)configs.get(Key);
    }

    void memoriseCommand(String command){

    }

}
