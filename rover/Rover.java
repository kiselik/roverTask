package netcracker.intensive.rover;

import netcracker.intensive.rover.constants.Direction;

public class Rover implements Moveable, Landable, Liftable, Turnable {
    private Point current_point;
    private GroundVisor visor;
    private Direction current_direction;

    public Rover(GroundVisor visor) {
        current_point = new Point(0, 0);
        current_direction = Direction.SOUTH;
        this.visor = visor;

    }

   public Point getCurrentPosition() {
        return current_point;
    }

    Direction getDirection() {
        return current_direction;
    }

    boolean isAirborne() {
        if (current_point == null)
            return true;
        else
            return false;
    }

    @Override
    public void move() {
        if (current_point != null)
        //делаем копию текущей ячейки. Если "следующая" ячейка занята,то мы никуда не уйдем.
        // Данные о текущем местоположении не потеряем
        {
            Point tmp = new Point(current_point);

            switch (current_direction) {
                case NORTH:
                    tmp.changeY(-1);
                    break;
                case SOUTH:
                    tmp.changeY(1);
                    break;
                case WEST:
                    tmp.changeX(-1);
                    break;
                case EAST:
                    tmp.changeX(1);
                    break;
            }
            try {
                //если препятствий нет и не вылетели за границу,то класс, переместились
                if (!visor.hasObstacles(tmp))
                    current_point.setNewPoint(tmp);
            } catch (OutOfGroundException e)// или кинули Exception и улетели
            {
                System.out.println(e.getMessage());
                lift();
            }
        }
    }


    @Override
    public void turnTo(Direction new_direction) {
        current_direction = new_direction;
    }

    @Override
    public void land(Point position, Direction direction) {
        try {
            //препятствий нет, приземляемся
            if (!visor.hasObstacles(position)) {
                current_point=new Point(position);
                current_direction = direction;
            }
        } catch (OutOfGroundException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void lift() {
        if (current_point != null) {
            current_point = null;
            current_direction = null;
        }
    }
}