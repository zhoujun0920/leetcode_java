class Solution {
    public int maxProfit(int[] prices) {
      int profit = 0;
      for (int i = 0; i < prices.length; i++) {
        for (int j = i + 1; j < prices.length; j++) {
          profit = profit > prices[j] - prices[i] ? profit : prices[j] - prices[i];
        }
      }
      return profit;
    }
}

class Solution {
    public int maxProfit(int[] prices) {
      int n = prices.length;
      if (n <= 1) {
        return 0;
      }
      int high = 0;
      int low = Integer.MAX_VALUE;
      int profit = 0;
      for (int i = 0; i < n; i++) {
        if (low < high) {
          profit = profit > high - low ? profit : high - low;
        }
        if (prices[i] < low) {
          low = prices[i];
        } else if (prices[i] > high) {
          high = prices[i];
        }
      }
      profit = profit > high - low ? profit : high - low;
      return profit;
    }
}
