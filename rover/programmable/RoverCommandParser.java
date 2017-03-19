package netcracker.intensive.rover.programmable;

import netcracker.intensive.rover.Point;
import netcracker.intensive.rover.command.*;
import netcracker.intensive.rover.constants.Direction;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class RoverCommandParser {
    private String path;
    private ProgrammableRover programmable_rover;
    private RoverProgram program;

    public RoverCommandParser(ProgrammableRover cur_rover, String cur_path) {
        programmable_rover = cur_rover;
        path = cur_path;
        program = new RoverProgram();
    }

    private Point getPoint(String x, String y) {
        int new_x = Integer.parseInt(x);
        int new_y = Integer.parseInt(y);
        return new Point(new_x, new_y);
    }

    private Direction getDirection(String name) {
        Direction tmp;
        switch (name) {
            case "east":
                tmp = Direction.EAST;
                break;
            case "west":
                tmp = Direction.WEST;
                break;
            case "south":
                tmp = Direction.SOUTH;
                break;
            case "north":
                tmp = Direction.NORTH;
                break;
            default:
                tmp = null;
        }
        return tmp;
    }

    RoverProgram getProgram() {

        String[] command;
        String tmp;
        try {
            ///включили буферезированное считывания из файла,если смогли
            BufferedReader reader = new BufferedReader(new FileReader(this.getClass().getResource(path).getFile()));
            //пока файл не пуст и пока текущая строка-не разделитель "==="
            //String tmp=reader.readLine();
            while (((tmp = reader.readLine()) != null) && (!tmp.equals(RoverProgram.SEPARATOR))) {
                command = tmp.split(" ");
                switch (command[1]) {
                    case "on":
                        program.memoriseConfig(command[0], true);
                        break;
                    case "off":
                        program.memoriseConfig(command[0], false);
                        break;
                }
            }
            while ((tmp = reader.readLine()) != null) {
                if (!tmp.equals(RoverProgram.SEPARATOR)) {
                    if ((boolean) program.getSettings().get(RoverProgram.LOG)) {
                        command = tmp.split(" ");
                        switch (command[0]) {
                            case "move":
                                program.memoriseCommand(new LoggingCommand(new MoveCommand(programmable_rover)));
                                break;
                            case "lift":
                                program.memoriseCommand(new LoggingCommand(new LiftCommand(programmable_rover)));
                                break;
                            case "turn":
                                program.memoriseCommand(new LoggingCommand(new TurnCommand(programmable_rover, getDirection(command[1]))));
                                break;
                            case "land":
                                program.memoriseCommand(new LoggingCommand(new LandCommand(programmable_rover, getPoint(command[1], command[2]), getDirection(command[3]))));
                                break;
                        }
                    } else {
                        command = tmp.split(" ");
                        switch (command[0]) {
                            case "move":
                                program.memoriseCommand(new MoveCommand(programmable_rover));
                                break;
                            case "lift":
                                program.memoriseCommand(new LiftCommand(programmable_rover));
                                break;
                            case "turn":
                                program.memoriseCommand(new TurnCommand(programmable_rover, getDirection(command[1])));
                                break;
                            case "land":
                                program.memoriseCommand(new LandCommand(programmable_rover, getPoint(command[1], command[2]), getDirection(command[3])));
                                break;

                        }
                    }
                }
            }
            reader.close();
        } catch (NullPointerException ex) {
            throw new RoverCommandParserException(ex, "Я не смог найти файл :" + path + " Увы( ");
        } catch (IOException ex) {
            throw new RoverCommandParserException(ex, "Впроцессе работы возникли проблемы при чтении файла :" + path + "Увы");
        }
        return program;
    }

}
