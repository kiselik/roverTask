
package netcracker.intensive.rover.programmable;

import netcracker.intensive.rover.command.RoverCommand;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class RoverCommandParser implements RoverCommand {
    private String path;
    private ProgrammableRover programmable_rover;
    private String[] command;
    private RoverProgram program;

    public RoverCommandParser(ProgrammableRover cur_rover, String cur_path) {
        programmable_rover = cur_rover;
        path = cur_path;
        program = new RoverProgram();
    }

    void doParsFile() {
        try {

            //включили буферезированное считывания из файла,если смогли
            BufferedReader reader = new BufferedReader(new FileReader(this.getClass().getResource(path).getFile()));

            //пока файл не пуст и пока текущая строка-не разделитель "==="
            while ((reader.readLine() != null) && (!reader.readLine().equals(RoverProgram.SEPARATOR))) {
                command = reader.readLine().split(" ");
                switch (command[1]) {
                    case "on":
                        program.memoriseConfig(command[0], true);
                        break;
                    case "off":
                        program.memoriseConfig(command[0], false);
                        break;
                }
            }
        } catch (IOException ex) {

        }
    }

    @Override
    public void execute() {

    }
}
