package netcracker.intensive.rover;

/**
 * Это исключение должно быть проверяемым - оно возникает, если ровер вышел за пределы поверхности
 */
public class OutOfGroundException extends Exception {

    OutOfGroundException() {
        //возможно, сюда добавить взлет
        super("ты чуть не упал! Какой кошмар!");
    }


}
