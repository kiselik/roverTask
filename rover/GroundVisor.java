package netcracker.intensive.rover;

import netcracker.intensive.rover.constants.CellState;

public class GroundVisor {
    private Ground ground;


    GroundVisor(Ground tmp_ground) {
        ground = tmp_ground;
    }

    // throws означает, что этот класс может выбросить исключения типа OutOfGroundException
    // и только его может выбросить данный момент(незаявленные типы не может?)
    CellState hasObstacles(GroundCell cell) throws OutOfGroundException {
        //вспомогательные перемменные, чтобы не грузить if
        return cell.getState();
       /* int tmp_x = cell.getPoint().getX();
        int tmp_y = cell.getPoint().getY();
        Point tmp = new Point(tmp_x, tmp_y);
        if ((tmp.getX() < 0) || (tmp.getX() > ground.getRow()) || (tmp.getY() < 0) || (tmp.getY() > ground.getColumn())) {
            throw new OutOfGroundException();
        } else {
            return cell.getState();
        }*/

    }

}
