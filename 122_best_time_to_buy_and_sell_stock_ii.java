class Solution {
    public int maxProfit(int[] prices) {
      int n = prices.length;
      if (n <= 1) {
        return 0;
      }
      int profit = 0;
      int low = -1;
      int high = 1;
      for (int i = 1; i < n; i++) {
        if (prices[i] > prices[i - 1]) {
          high++;
        } else {
          if (low == -1) {
            low = prices[i];
          } else {
            profit += high - low;
            low = prices[i + 1];
            high = 0;
          }
        }
      }
      return profit;
    }
}
