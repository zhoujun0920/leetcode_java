class Solution {
    public int maxProfit(int[] prices) {
      int n = prices.length;
      if (n <= 1) {
        return 0;
      }
      int profit = 0;
      int low = 0;
      int high = 0;
      for (int i = 1; i < n; i++) {
        if (prices[i] > prices[i - 1]) {
          high++;
          if (high == n - 1) {
            profit += prices[high] - prices[low];
            return profit;
          }
        } else {
          profit += prices[high] - prices[low];
          low = i;
          high = i;
        }
      }

      return profit;
    }
}
