
package netcracker.intensive.rover.programmable;

import netcracker.intensive.rover.Point;
import netcracker.intensive.rover.command.*;
import netcracker.intensive.rover.constants.Direction;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collection;

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
        try  {
            ///включили буферезированное считывания из файла,если смогли
            BufferedReader reader = new BufferedReader(new FileReader(this.getClass().getResource(path).getFile()));
            //пока файл не пуст и пока текущая строка-не разделитель "==="
            //String tmp=reader.readLine();
            while ((( tmp=reader.readLine()) != null) && (!tmp.equals(RoverProgram.SEPARATOR))) {
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
            while ((tmp=reader.readLine())!= null) {
                if (!tmp.equals(RoverProgram.SEPARATOR)) {
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
            //еслилогирование включено и файл не был изначально пустым,
            // перепишем найденные комманды через логированные команды
            if((program.getSettings().size()!=0)&&(boolean)program.getSettings().get(RoverProgram.LOG))
            {
                RoverProgram new_log_program=new RoverProgram();
                for(RoverCommand index: program.getCommands())
                {
                     new_log_program.memoriseCommand(new LoggingCommand(index));
                }
                program=new_log_program;
            }
            reader.close();
        } catch (NullPointerException ex) {
            throw new RoverCommandParserException(ex);
        } /*catch (FileNotFoundException ex) {
            throw new RoverCommandParserException(ex);
        } */catch (IOException ex) {
            throw new RoverCommandParserException(ex);
        }

        return program;
    }

}
