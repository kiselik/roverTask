package netcracker.intensive.rover.stats;

import netcracker.intensive.rover.Point;

import java.util.ArrayList;
import java.util.Collection;

public class SimpleRoverStatsModule implements RoverStatsModule {
    private ArrayList<Point> visitedCells;

    public SimpleRoverStatsModule() {
        visitedCells = new ArrayList<Point>();
    }

    @Override
    public void registerPosition(Point position) {
        if (!visitedCells.contains(position))
            visitedCells.add(position);
    }

    @Override
    public boolean isVisited(Point point) {
        return visitedCells.contains(point);
    }

    @Override
    public Collection<Point> getVisitedPoints() {
        return visitedCells;
    }

}
