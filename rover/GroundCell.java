package netcracker.intensive.rover;

import netcracker.intensive.rover.constants.CellState;

public class GroundCell {

    private Point current_point;
    private CellState state;

    GroundCell(CellState cur_state) {
        state = cur_state;
    }

  /*  void SetPoint(int cur_x, int cur_y) {
        current_point = new Point(cur_x, cur_y);
    }

    void SetPoint(Point point) {
        current_point = point;
    }*/

    CellState getState() {
        return state;
    }

 /*   Point getPoint() {
        return current_point;
    }*/
}
