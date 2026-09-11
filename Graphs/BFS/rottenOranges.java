package Graphs.BFS;

import java.util.LinkedList;
import java.util.Queue;

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

public class rottenOranges {

    public int orangesRotting(int[][] grid) {


         if (grid == null || grid.length == 0)
    
            return 0;

             int n = grid.length;
        int m = grid[0].length;

        int vis[][] = new int[n][m];
       

        int countFresh = 0;
        Queue<tuple> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {

            for (int j = 0; j <m; j++) {
                if (grid[i][j] == 2) {
                    q.add(new tuple(i, j, 0));
                    vis[i][j] = 2;
                } else {
                    vis[i][j] = 0;
                }
                if (grid[i][j] == 1) {
                    countFresh++;
                }

            }

        }

        int[] delRow = { -1, 0, 1, 0 };
        int[] delCol = { 0, 1, 0, -1 };

        int countRotten = 0;
        int minAnsTime = 0;

        if (countFresh == 0)
            return 0;

        while (!q.isEmpty()) {

            int i = q.peek().first;
            int j = q.peek().second;
            int time = q.peek().third;

            minAnsTime = Math.max(minAnsTime, time);

            q.remove();

            for (int k = 0; k < 4; k++) {

                int nRow = i + delRow[k];
                int nCol = j + delCol[k];

                if (nRow >= 0 && nRow < n && nCol >= 0 && nCol < m && vis[nRow][nCol] == 0 && grid[nRow][nCol] == 1) {
                    vis[nRow][nCol] = 2;
                    q.add(new tuple(nRow, nCol, time + 1));
                    countRotten++;

                }

            }

        }

        if (countFresh != countRotten)
            return -1;

        return minAnsTime;

    }
}
