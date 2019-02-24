class Solution {
    public int maxProfit(int[] prices) {
      int n = prices.length;
      int profit1 = 0;
      int profit2 = 0;
      int low = 0;
      int high = 0;
      for (int i = 1; i < n; i++) {
        if (prices[i] > prices[i - 1]) {
          high++;
          if (high == n - 1) {
            int temp = prices[high] - prices[low];
            if (temp > profit1) {
              profit1 = profit2;
              profit2 = temp;
            } else if (temp > profit2) {
              profit2 = temp;
            }
            return profit1 + profit2;
          }
        } else {
          int temp = prices[high] - prices[low];
          if (temp > profit1) {
            profit1 = profit2;
            profit2 = temp;
          } else if (temp > profit2) {
            profit2 = temp;
          }
          low = i;
          high = i;
        }
      }
      return profit1 + profit2;
    }
}
