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

    //пытаемся найти ячейку с заданными координатами на поле
   GroundCell getCell(Point cur_point) throws OutOfGroundException {
        return getCell(cur_point.getX(), cur_point.getY());
    }

    GroundCell getCell(int cur_x, int cur_y) throws OutOfGroundException {
        GroundCell tmp = ground[cur_x * column + cur_y];
        if ((cur_x < 0) || (cur_y < 0) || (cur_y > column) || (cur_x > row)) {
            throw new OutOfGroundException();
        } else
            return tmp;
    }

    public int getColumn() {
        return column;
    }

    public int getRow() {
        return row;
    }
}
