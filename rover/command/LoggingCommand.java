package netcracker.intensive.rover.command;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingCommand implements RoverCommand {
    private RoverCommand log_command;

    public static final Logger LOGGER = LoggerFactory.getLogger(LoggingCommand.class);

    public LoggingCommand(RoverCommand command) {
        log_command=command;
    }
    @Override
    public void execute() {
        LOGGER.info(log_command.toString());
        log_command.execute();
    }

    @Override
    public String toString() {
        return log_command.toString();

    }
}
