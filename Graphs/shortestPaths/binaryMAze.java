package Graphs.shortestPaths;

import java.util.Arrays;
import java.util.PriorityQueue;

class tuple {

    int first;
    int second;
    int third;

    tuple(int _first, int _second, int _third) {
        this.first = _first;
        this.second = _second;
        this.third = _third;
    }

}

public class binaryMAze {
    public int shortestPathBinaryMatrix(int[][] grid) {

        int n = grid.length;
      

        if (grid[n - 1][n - 1] == 1 || grid[0][0] == 1)
            return -1;

        int dist[][] = new int[n][n];

        PriorityQueue<tuple> pq = new PriorityQueue<>((x, y) -> x.third - y.third);

        for (int i[] : dist) {
            Arrays.fill(i, (int) 1e9);
        }

        dist[0][0] = 1;

        pq.add(new tuple(0, 0, 1));

        int[][] directions = {
                { -1, -1 }, { -1, 0 }, { -1, 1 },
                { 0, -1 }, { 0, 1 },
                { 1, -1 }, { 1, 0 }, { 1, 1 }
        };

    

        while (pq.size() != 0) {

            int row = pq.peek().first;
            int col = pq.peek().second;
            int dis = pq.peek().third;

            pq.remove();

            if (row == n - 1 && col == n - 1)
                return dis;

            for (int[] dir : directions) {
                int nrow = row + dir[0];
                int ncol = col + dir[1];

                if (nrow < n && ncol < n && nrow >= 0 && ncol >= 0 && grid[nrow][ncol] == 0
                        && 1 + dis < dist[nrow][ncol]) {

                    dist[nrow][ncol] = 1 + dis;

                    pq.add(new tuple(nrow, ncol, dis + 1));

                }
            }

        }

        return -1;

    }
}
