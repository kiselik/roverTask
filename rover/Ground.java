package netcracker.intensive.rover;

public class Ground {
    private int column, row;
    private GroundCell[][] landscape;

    Ground(int cur_row, int cur_column) {
        column = cur_column;
        row = cur_row;
        landscape = new GroundCell[row][column];
    }

    //ЗАПОМНИ!!!!!!
    //х- column
    //y-row
    void initialize(GroundCell... cells) {
        if (cells.length < row * column)
            throw new IllegalArgumentException();

        if (cells.length != 0) {

            for (int i = 0; i < row; i++)
                for (int j = 0; j < column; j++) {
                    landscape[i][j] = cells[i * row + j];
                }
        }
    }

/*    //пытаемся найти ячейку с заданными координатами на поле
    GroundCell getCell(Point cur_point) throws OutOfGroundException {
        return getCell(cur_point.getX(), cur_point.getY());
    }*/

    //x-column
    //y-row
    GroundCell getCell(int cur_x, int cur_y) throws OutOfGroundException {

        try {
            return landscape[cur_y][cur_x];
        } catch (IndexOutOfBoundsException e) {
            throw new OutOfGroundException();
        }
    }

    public int getColumn() {
        return column;
    }

    public int getRow() {
        return row;
    }
}
