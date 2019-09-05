package recursivedp;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Imagine a robot sitting on the upper left corner of grid with r rows and c columns.
 * The robot can only move in two directions, right and down, but certain cells are "off limits"
 * such that the robot cannot step on them. Design an algorithm to find a path for the robot
 * from the top left to the bottom right.
 */
class _08_02_RobotInAGrid {
    List<Point> findPath(boolean[][] grid) {

        List<Point> result = new ArrayList<>();
        result.add(new Point(0, 0));
        if(grid.length == 1 && grid[0].length == 1) {
            return result;
        }
        helper(grid, result);
        if(result.size() == 1) {
            return new ArrayList<>();
        }
        return result;
    }

    boolean helper(boolean[][] grid, List<Point> result) {
        Point current = result.get(result.size() - 1);
        int x = (int) current.getX();
        int y = (int) current.getY();

        int maxLength = grid.length + grid[0].length - 1;
        if(result.size() == maxLength) {
            return true;
        } else {
            // need to recurse
            boolean found = false;

            // go right and see
            if(x + 1 < grid[0].length && grid[y][x + 1]) {
                Point right = new Point(x + 1, y);
                result.add(right);
                found = found || helper(grid, result);
                if(!found) {
                    result.remove(result.size() - 1);
                }
            }

            // go down and see
            if(!found && y + 1 < grid.length && grid[y + 1][x]) {
                Point down = new Point(x, y + 1);
                result.add(down);
                found = found || helper(grid, result);
                if(!found) {
                    result.remove(result.size() - 1);
                }
            }

            return found;
        }
    }


}
