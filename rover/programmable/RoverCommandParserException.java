package netcracker.intensive.rover.programmable;

/**
 * Это исключение должно быть непроверяемым - оно происходит, когда возникает ошибка чтения файла с программой для ровера.
 * Дальнейшее выполнение программы становится невозможным. Исключение должно содержать информации о породившем его исключении.
 */
import java.io.IOException;

public class RoverCommandParserException extends Exception{
    RoverCommandParserException(Exception e) {
        super("возникли проблемы при работе с файлом",e);
        printStackTrace();
        System.exit(-1);
    }
}