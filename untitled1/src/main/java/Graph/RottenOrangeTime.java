package main.java.Graph;

public class RottenOrangeTime {
    public static void main(String args[]) {
        Solution solution = new Solution();
        int[][] arr = {{2}, {1}, {1}, {1}, {2}, {1}, {1}};
        System.out.println(solution.orangesRotting(arr));
    }
}


class Solution {
    Integer timeEach[][];

    public int orangesRotting(int[][] grid) {
        if (grid.length == 0) return 0;
        timeEach = new Integer[grid.length][grid[0].length];
        initialize(grid);
        Helper(grid);
        return getTime(grid);
    }

    void initialize(int[][] grid) {
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                timeEach[i][j] = (grid[i][j] == 2) ? 0 : Integer.MAX_VALUE;
            }
        }
    }

    void Helper(int[][] grid) {
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                if (grid[i][j] == 2) {
                    DFS(i, j, grid, 0);
                }
            }
        }
    }

    void DFS(int i, int j, int[][] grid, int level) {
        if (timeEach[i][j] > level) {
            timeEach[i][j] = level;
        }
        int[] x = {0, 0, -1, 1};
        int[] y = {1, -1, 0, 0};
        for (int m = 0; m < x.length; ++m) {
            if (isValid(i + x[m], j + y[m], grid,level+1)) {
                DFS(i + x[m], j + y[m], grid, level + 1);
            }
        }
    }

    int getTime(int[][] grid) {
        int time = 0;
        for (int i = 0; i < timeEach.length; ++i) {
            for (int j = 0; j < timeEach[0].length; ++j) {
                if (grid[i][j] == 1) {
                    if (timeEach[i][j] == Integer.MAX_VALUE) {
                        return -1;
                    }
                    time = Math.max(time, timeEach[i][j]);
                }

            }
        }
        return time;
    }


    Boolean isValid(int i, int j, int[][] grid,int time) {
        return i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && grid[i][j] == 1 && timeEach[i][j]>time;
    }
}