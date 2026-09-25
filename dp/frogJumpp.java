package dp;

import java.util.Arrays;

public class frogJumpp {

    // public static int helper(int index, int heights[], int[] dp) {

    // if (index == 0) {
    // return 0;
    // }

    // if (dp[index] != -1)
    // return dp[index];

    // int oneStep = helper(index - 1, heights, dp) + Math.abs(heights[index] -
    // heights[index - 1]);

    // int twoStep = Integer.MAX_VALUE;

    // if (index > 1) {
    // twoStep = helper(index - 2, heights, dp) + Math.abs(heights[index] -
    // heights[index - 2]);

    // }

    // return dp[index]=Math.min(oneStep, twoStep);
    // }

    public static int frogJump(int[] heights) {
        int n = heights.length;
        int[] dp = new int[n + 1];

  

        for (int i = 1; i < n; i++) {

            int oneStep = dp[i - 1] + Math.abs(heights[i] - heights[i - 1]);

            int twoStep = Integer.MAX_VALUE;

            if (i > 1) {
                twoStep = dp[i - 2] + Math.abs(heights[i] - heights[i - 2]);

            }

            dp[i] = Math.min(oneStep, twoStep);

        }

        return dp[n - 1];

    }

    public static void main(String[] args) {
        int heighs[] = { 7, 5, 1, 2, 6 };

        System.out.println(frogJump(heighs));

    }

}
