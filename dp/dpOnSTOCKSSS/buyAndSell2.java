package dp.dpOnSTOCKSSS;

import java.util.Arrays;

public class buyAndSell2 {

  public static  int function(int[] prices, int index, int buy, int n, int [][] dp) {

    if (index == n)
      return 0;

    int profit = 0;
    if (buy == 1) {

      profit = Math.max(-prices[index] + function(prices, index + 1, 0, n , dp),
          0 + function(prices, index + 1, 1, n, dp));

    } else {
      profit += Math.max(prices[index] + function(prices, index + 1, 1, n, dp),
          0 + function(prices, index + 1, 0, n , dp));
    }

    return profit;

  }

  public static  int maxProfit(int[] prices) {

    int [][] dp= new int[prices.length][2];
     for(int it[] : dp){
            Arrays.fill(it , -1);
        }
    return function(prices, 0, 1, prices.length, dp);

  }


  public static void main(String[] args) {
    int [] prices= {1,2,3,4,5};

    System.out.println(maxProfit(prices));
  }
}