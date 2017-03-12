package netcracker.intensive.rover;

//не забудьте реализовать equals, hashCode, toString!
public class Point {
    private int x;
    private int y;

    Point() {
        x = 0;
        y = 0;
    }

    Point(int cur_x, int cur_y) {
        x = cur_x;
        y = cur_y;
    }

    int getX() {
        return x;
    }

    int getY() {
        return y;
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

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return super.toString();
    }

}
