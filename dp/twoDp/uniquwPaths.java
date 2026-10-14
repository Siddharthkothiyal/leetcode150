package dp.twoDp;

import java.util.Arrays;

public class uniquwPaths {

     public static int function(int i , int j , int m , int n , int dp[][]){
        if(i<0 || j<0) return 0;

        if(i==0 &&j==0) return 1;

        if(dp[i][j] != -1) return dp[i][j];

        int up=   function(i-1, j ,  m , n , dp);
        int left= function(i ,j-1 , m ,  n , dp);


        return dp[i][j] = up+left;
    }
    public int uniquePaths(int m, int n) {

        int dp[][] = new int[m][n];

        for(int [] d :dp){
            Arrays.fill(d, -1);
        }

        return function(m-1 , n-1 , m ,  n , dp);
        
    }
    
}
