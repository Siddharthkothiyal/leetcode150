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

public class dist01 {
    public int[][] updateMatrix(int[][] mat) {
        Queue<tuple> q = new LinkedList<>();
        int n = mat.length;
        int m = mat[0].length;

        int[][] dist = new int[n][m];
        int[][] vis = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (mat[i][j] == 0) {
                      q.add(new tuple(i, j, 0));
                    vis[i][j] = 1;
                } else {
                    vis[i][j] = 0;
                }

            }
        }


      


          int[] delRow = { -1, 0, 1, 0 };
        int[] delCol = { 0, 1, 0, -1 };


        while (!q.isEmpty()) {

            int r= q.peek().first;
            int c = q.peek().second;
            int steps = q.peek().third;

            q.remove();

            dist[r][c]= steps;

            for (int i = 0; i < 4; i++) {

                int nrow= r+ delRow[i];
                int ncol = c+ delCol[i];

                if (nrow>=0 && ncol>= 0 && nrow<n && ncol<m  && vis[nrow][ncol]== 0 ) {
                    vis[nrow][ncol]=1;
                    q.add(new tuple(nrow, ncol, steps+1));
                }
                
            }
            
        }



return dist;


    }

}
