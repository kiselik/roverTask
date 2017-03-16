package netcracker.intensive.rover;

import netcracker.intensive.rover.constants.CellState;

public class GroundVisor {
    private Ground ground;


    GroundVisor(Ground tmp_ground) {
        ground = tmp_ground;
    }

    Ground getGround(){
        return ground;
    }

    // throws означает, что этот класс может выбросить исключения типа OutOfGroundException
    // и только его может выбросить данный момент(незаявленные типы не может?)
 /*  boolean hasObstacles(GroundCell cell) throws OutOfGroundException {
      *//*  //попробуем получить ячейку с такими координатами. Если вышли за диапазон, кинем Exception
        GroundCell tmp=ground.getCell(cell.getPoint());
        return tmp.getState();*//*
      return hasObstacles(cell.getPoint());
    }*/

    boolean hasObstacles(Point point) throws OutOfGroundException {
        GroundCell tmp=ground.getCell(point);
        if (tmp.getState()==CellState.FREE)
            return false;
        else
            return true;
    }

}
