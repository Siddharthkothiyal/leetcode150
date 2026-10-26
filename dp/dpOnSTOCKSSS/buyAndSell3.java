package dp.dpOnSTOCKSSS;

import java.util.Arrays;

public class buyAndSell3 {

    public static int function(int[] prices, int index, int buy, int n, int[][][] dp, int cap) {


                if (cap == 0)
            return 0;
        if (index == n)
            return 0;

        int profit = 0;

        if(dp[index][buy][cap] != -1) return dp[index][buy][cap] ;

        if (buy == 0) {
            profit = Math.max(-prices[index] + function(prices, index + 1, 1, n, dp, cap),
                    0 + function(prices, index + 1, 0, n, dp, cap));

        }

        else {
            profit += Math.max(prices[index] + function(prices, index + 1, 0, n, dp, cap-1),
                    0 + function(prices, index + 1, 1, n, dp, cap));

        }

        return dp[index][buy][cap] =profit;

    }

    public static int maxProfit(int[] prices) {
        int n = prices.length;

        int[][][] dp = new int[prices.length][2][3];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        return function(prices, 0, 0, n, dp, 2);

    }

    public static void main(String[] args) {
         int [] prices= {3,3,5,0,0,3,1,4};

    System.out.println(maxProfit(prices));
    }

}
