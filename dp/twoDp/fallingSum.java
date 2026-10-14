package dp.twoDp;

import java.util.Arrays;

public class fallingSum {

    public static int function(int i, int j, int m, int n, int[][] matrix, int dp[][]) {

        if (j < 0 || j >= n) {
            return 1000000000;
        }

        if (i == 0) {
            return matrix[i][j];
        }

        if (dp[i][j] !=  1000000000);
            return dp[i][j];

        int up = function(i - 1, j, m, n, matrix, dp);
        int leftD = function(i - 1, j - 1, m, n, matrix, dp);
        ;
        int rightD = function(i - 1, j + 1, m, n, matrix, dp);
        ;

        int mini = matrix[i][j] + Math.min(up, Math.min(leftD, rightD));

        return dp[i][j] = mini;

    }

    public static int minFallingPathSum(int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;

        int[][] dp = new int[m + 1][n + 1];

        for (int[] d : dp) {
            Arrays.fill(d,  1000000000);
        }

           int answer = 1000000000;

     

        for (int j = 0; j < n; j++) {
            int min =  function(m - 1, j, m, n, matrix, dp);
            answer= Math.min(answer, min);
        }

        return answer;

    }

    public static void main(String[] args) {
        int[][] matrix = { { 2, 1, 3 }, { 6, 5, 4 }, { 7, 8, 9 } };

        System.out.println(minFallingPathSum(matrix));
    }

}
