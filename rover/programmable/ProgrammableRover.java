package netcracker.intensive.rover.programmable;

import netcracker.intensive.rover.GroundVisor;
import netcracker.intensive.rover.Point;
import netcracker.intensive.rover.Rover;
import netcracker.intensive.rover.command.RoverCommand;
import netcracker.intensive.rover.stats.SimpleRoverStatsModule;

/*
 * Этот класс должен уметь все то, что умеет обычный Rover, но при этом он еще должен уметь выполнять программы,
 * содержащиеся в файлах
*/
public class ProgrammableRover extends Rover implements ProgramFileAware {
    private RoverCommandParser parser;
    private SimpleRoverStatsModule stats_module;
    private RoverProgram program;

    public ProgrammableRover(GroundVisor visor, SimpleRoverStatsModule module) {
        //вызвали конструктор, поставили планетоход на поле
        super(visor);
        stats_module = new SimpleRoverStatsModule();
        program = new RoverProgram();
    }

    @Override
    public void executeProgramFile(String path) {
       /* parser = new RoverCommandParser(this, path);

        parser.doParsFile();
        for (RoverCommand commands : program.getCommands()) {
            commands.execute();
              List<RoverCommand> tmp=(List<RoverCommand>) program.getCommands();
        for (RoverCommand index:tmp)
            index.execute();
        }*/
    }


    Point getCurrentPoint() {
        return super.getCurrentPosition();
    }


}
