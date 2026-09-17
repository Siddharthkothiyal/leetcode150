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

public class pathwithMinEffort {
    public int minimumEffortPath(int[][] heights) {

        int n = heights.length;
        int m = heights[0].length;

        int dist[][] = new int[n][m];

        PriorityQueue<tuple> pq = new PriorityQueue<>((x, y) -> x.third - y.third);

        for (int i[] : dist) {
            Arrays.fill(i, (int) 1e9);
        }

        dist[0][0] = 0;

        pq.add(new tuple(0, 0, 0));

        int[] delRow = { -1, 0, 1, 0 };
        int[] delCol = { 0, 1, 0, -1 };

        while (pq.size() != 0) {
            int row = pq.peek().first;
            int col = pq.peek().second;
            int minEffort = pq.peek().third;

            pq.remove();

            if (row == n - 1 && col == m - 1)
                return minEffort;

            for (int i = 0; i < 4; i++) {
                int nrow = row + delRow[i];
                int ncol = col + delCol[i];

                if (nrow < n && ncol < m && nrow >= 0 && ncol >= 0) {

                    int effort = Math.max(Math.abs(heights[row][col] - heights[nrow][ncol]), minEffort);

                    if (effort < dist[nrow][ncol]) {
                        dist[nrow][ncol] = effort;
                        pq.add(new tuple(nrow, ncol, effort));
                    }

                }

            }

        }
        return 0;

    }
}
