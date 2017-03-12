package netcracker.intensive.rover;

public class Ground {
    private int column, row;
    private static GroundCell[] ground;

    Ground(int cur_row, int cur_column) {
        column = cur_column;
        row = cur_row;
        ground = new GroundCell[column * row];

    }

    void initialize(GroundCell... cells) {
        if (cells.length != 0) {
            for (int i = 0; i < cells.length; i++) {
                ground[i] = cells[i];
                //по номеру ячейки вычисляем координаты
                int x = i / column;
                int y = i - 1;
                cells[i].SetPoint(x, y);
            }

        }
    }

   /* GroundCell getCell(Point cur_point) {
        //для пользователя покажем +1 к этому результату
        return ground[cur_point.getX()*column+cur_point.getY()];
    }*/

    GroundCell getCell(int cur_x, int cur_y) {
        return ground[cur_x * column + cur_y];
    }


}
