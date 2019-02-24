class Solution {
    public int maxProfit(int[] prices) {
      int n = prices.length;
      if (n <= 1) {
        return 0;
      }
      int buy = 0;
      int sold = -Integer.MAX_VALUE;
      int rest = 0;
      for (int i = 1; i < n; i++) {
        buy = buy > buy + sold ? buy : buy + sold;
        sold = sold > sold + prices[i] ? sold : sold + prices[i];
        rest = 
      }
      return profit;
    }
}
