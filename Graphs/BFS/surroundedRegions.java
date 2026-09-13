package Graphs.BFS;

public class surroundedRegions {

    public static void dfs(int row, int col, int[][] vis, char[][] board) {

        vis[row][col] = 1;

        int n = board.length;
        int m = board[0].length;

        int[] delRow = { -1, 0, 1, 0 };
        int[] delCol = { 0, 1, 0, -1 };

        for (int i = 0; i < 4; i++) {

            int nrow = row + delRow[i];
            int ncol = col + delCol[i];

            if ( nrow < n && ncol < m && nrow >= 0 && ncol >= 0  && vis[nrow][ncol] == 0 && board[nrow][ncol] == 'O') {
               
                dfs(nrow, ncol, vis, board);

            }

        }

    }

    public static void solve(char[][] board) {

        int n = board.length;
        int m = board[0].length;

        int[][] vis = new int[n][m];

        for (int i = 0; i < n; i++) {

            // first col and last lastcol

            if (vis[i][0] == 0 && board[i][0] == 'O') {
                dfs(i, 0, vis, board);
            }

            if (vis[i][m - 1] == 0 && board[i][m - 1] == 'O') {
                dfs(i, m - 1, vis, board);
            }

        }

        for (int j = 0; j < m; j++) {

            // first row and last row

            if (vis[0][j] == 0 && board[0][j] == 'O') {
                dfs(0, j, vis, board);
            }

            if (vis[n - 1][j] == 0 && board[n - 1][j] == 'O') {
                dfs(n - 1, j, vis, board);
            }

        }

        // if the node is still univisted apart from the boaundary then it should be
        // marked with x
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (vis[i][j] == 0 && board[i][j] == 'O')
                    board[i][j] = 'X';
            }
        }

    }


    public static void main(String[] args) {
       char[][] board = {
    {'X', 'X', 'X', 'X'},
    {'X', 'O', 'O', 'X'},
    {'X', 'X', 'O', 'X'},
    {'X', 'O', 'X', 'X'}
};

solve(board);


for (int i = 0; i < board.length; i++) {
    for (int j = 0; j < board.length; j++) {
        System.out.print(board[i][j] + " ");
    }
}
    }
}
