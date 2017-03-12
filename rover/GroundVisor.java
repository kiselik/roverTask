package netcracker.intensive.rover;

import netcracker.intensive.rover.constants.CellState;

public class GroundVisor {
    private int row_size;
    private int column_size;

    GroundVisor(int row_count, int column_count) {
        row_size = row_count;
        column_size = column_count;
    }

    // throws означает, что этот класс может найти исключения типа OutOfGroundException
    // и только его может выбросить данный момент(незаявленные типы не может?)
    CellState checkCell(GroundCell cell) throws OutOfGroundException {
        //вспомогательные перемменные, чтобы не грузить if

        int tmp_x = cell.getPoint().getX();
        int tmp_y = cell.getPoint().getY();
        Point tmp = new Point(tmp_x, tmp_y);
        if ((tmp.getX() < 0) || (tmp.getX() > row_size) || (tmp.getY() < 0) || (tmp.getY() > column_size)) {
            throw new OutOfGroundException("Ай,ай,ай ! Ты чуть не упал! Что же ты будешь без меня делать?");
        } else {
            return cell.getState();
        }

    }

}
