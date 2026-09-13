package Graphs.BFS;

public class noOfEnc {

public static void dfs(int row , int col , int [][] vis , int [][]grid){

     vis[row][col] = 1;

        int n = grid.length;
        int m = grid[0].length;

        int[] delRow = { -1, 0, 1, 0 };
        int[] delCol = { 0, 1, 0, -1 };

        for (int i = 0; i < 4; i++) {

            int nrow = row + delRow[i];
            int ncol = col + delCol[i];

            if ( nrow < n && ncol < m && nrow >= 0 && ncol >= 0  && vis[nrow][ncol] == 0 && grid[nrow][ncol] == 1) {
               
                dfs(nrow, ncol, vis, grid);

            }

        }

}


     public static int numEnclaves(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;


        int [][] vis = new int[n][m];

        int countEnclaves=0;


        // boundary cehck

         for (int i = 0; i < n; i++) {

            // first col and last lastcol

            if (vis[i][0] == 0 && grid[i][0] == 1) {
                dfs(i, 0, vis, grid);
            }

            if (vis[i][m - 1] == 0 && grid[i][m - 1] == 1) {
                dfs(i, m - 1, vis, grid);
            }

        }

        for (int j = 0; j < m; j++) {

            // first row and last row

            if (vis[0][j] == 0 && grid[0][j] == 1) {
                dfs(0, j, vis, grid);
            }

            if (vis[n - 1][j] == 0 && grid[n - 1][j] == 1) {
                dfs(n - 1, j, vis, grid);
            }

        }



        //now anything is beyound which is not countable;


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(grid[i][j] == 1 && vis[i][j]== 0){
                    countEnclaves ++;
                }
            }
        }


        return  countEnclaves;
        
    }

    public static void main(String[] args) {
        int [][] grid = {{0,1,1,0},{0,0,1,0},{0,0,1,0},{0,0,0,0}};

       System.out.println(numEnclaves(grid));
    }
    
}
