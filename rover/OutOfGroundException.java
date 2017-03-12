package netcracker.intensive.rover;

/**
 * Это исключение должно быть проверяемым - оно возникает, если ровер вышел за пределы поверхности
 */
public class OutOfGroundException extends Exception {

    OutOfGroundException(String message) {
        //возможно, сюда добавить взлет
        super(message);
    }


}
