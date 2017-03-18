package netcracker.intensive.rover;

//не забудьте реализовать equals, hashCode, toString!
public class Point {
    private int x;
    private int y;

   public Point() {
        x = 0;
        y = 0;
    }

    public Point(int cur_x, int cur_y) {
        x = cur_x;
        y = cur_y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    Point(Point newPoint){
        x=newPoint.getX();
        y=newPoint.getY();
    }

    void setNewPoint(Point newPoint){
        x=newPoint.getX();
        y=newPoint.getY();
    }

    @Override
    public boolean equals(Object obj) {

        if ((obj == null) || (obj.getClass() != this.getClass()))
            return false;
        if (obj == this)
            return true;

        Point tmp = (Point) obj;
        if ((this.x == tmp.x) && (this.y == tmp.y))
            return true;
        else
            return false;
    }

    void changeX(int dX){
        x+=dX;
    }

    void changeY(int dY){
        y+=dY;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return super.toString();
    }

}