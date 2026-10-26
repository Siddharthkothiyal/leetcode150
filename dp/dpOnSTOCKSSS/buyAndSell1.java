package dp.dpOnSTOCKSSS;

public class buyAndSell1 {
     public int maxProfit(int[] prices) {

        int mini=prices[0];
        int profit =0;

        for (int i = 1; i < prices.length; i++) {
             mini = Math.min(mini, prices[i]);
            profit =Math.max( prices[i] - mini , profit);
          
        }

        return profit;
        
    }
}
