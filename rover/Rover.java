package netcracker.intensive.rover;

import netcracker.intensive.rover.command.TurnCommand;
import netcracker.intensive.rover.constants.Direction;

public class Rover implements Moveable,Landable, Liftable, Turnable{
    private GroundCell current_cell;
    private GroundVisor visor;
    private Direction current_direction;

    public Rover(GroundVisor visor) /*throws OutOfGroundException */ {
        try {
            current_cell = visor.getGround().getCell(0, 0);
        } catch (OutOfGroundException e) {
            System.out.println(e.getMessage());
        }
        current_direction = Direction.SOUTH;

    }

    Point getCurrentPosition() {
        return current_cell.getPoint();
    }

    Direction getDirection() {
        return current_direction;
    }

    boolean isAirborne() {
        if (current_cell != null)
            return true;
        else
            return false;
    }

    @Override
    public void move() {
        //делаем копию текущей ячейки. Если "следующая" ячейка занята,то мы никуда не уйдем.
        // Данные о текущем местоположении не потеряем
        //может, сделать метод для создания копии ячейки?
        GroundCell tmp = new GroundCell(current_cell.getState());
        tmp.SetPoint(current_cell.getPoint().getX(), current_cell.getPoint().getX());

        switch (current_direction) {
            case NORTH:
                tmp.getPoint().changeY(-1);
                break;
            case SOUTH:
                tmp.getPoint().changeY(1);
                break;
            case WEST:
                tmp.getPoint().changeX(-1);
                break;
            case EAST:
                tmp.getPoint().changeX(1);
                break;
        }
        try {
            //если препятствий нет и не вылетели за границу,то класс, переместились
            if (visor.hasObstacles(tmp))
                current_cell = tmp;
        } catch (OutOfGroundException e)// или кинули Exception и улетели
        {
            System.out.println(e.getMessage());
            lift();
        }
    }


    @Override
    public void turnTo(Direction new_direction) {
        current_direction = new_direction;
    }

    @Override
    public void land(Point position, Direction direction) {
        try {
            if (visor.hasObstacles(position))
                current_cell.SetPoint(position);
            current_direction = direction;
        } catch (OutOfGroundException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void lift() {
        current_cell = null;
    }
}
