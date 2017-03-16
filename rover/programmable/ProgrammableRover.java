package netcracker.intensive.rover.programmable;

import netcracker.intensive.rover.GroundVisor;
import netcracker.intensive.rover.Rover;

import netcracker.intensive.rover.command.RoverCommand;
import netcracker.intensive.rover.programmable.RoverCommandParserException;
import netcracker.intensive.rover.stats.SimpleRoverStatsModule;

/**
 * Этот класс должен уметь все то, что умеет обычный Rover, но при этом он еще должен уметь выполнять программы,
 * содержащиеся в файлах
 */
public class ProgrammableRover extends Rover implements ProgramFileAware {
    private RoverCommandParser parser;
    private SimpleRoverStatsModule stats_module;

    public ProgrammableRover(GroundVisor visor,String path) {
        //вызвали конструктор, поставили планетоход на поле
        super(visor);
        stats_module=new SimpleRoverStatsModule();
        parser=new RoverCommandParser(this,path);
    }

    @Override
    public void executeProgramFile(String path)/*throws IOException*/ {
        /*parser.doParsFile();
        for (RoverCommand roverCommand : parser.roverProgram.commands){
            roverCommand.execute();
        }*/
    }
    SimpleRoverStatsModule getStatsModule(){
        return stats_module;

    }
}
