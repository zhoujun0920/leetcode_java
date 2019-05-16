// DP
// the first house has 3 options.
// from the second house, add the min of other options to the color

class Solution {

    public int minCost(int[][] costs) {
      int n = costs.length;
      if (n == 0) {
        return 0;
      }
      int[] memo = new int[3];
      for (int i = 0; i < 3; i++) {
        memo[i] = costs[0][i];
      }
      for (int i = 1; i < n; i++) {
        int temp0 = costs[i][0] + Math.min(memo[1], memo[2]);
        int temp1 = costs[i][1] + Math.min(memo[0], memo[2]);
        int temp2 = costs[i][2] + Math.min(memo[1], memo[0]);
        memo[0] = temp0;
        memo[1] = temp1;
        memo[2] = temp2;
      }
      return Math.min(Math.min(memo[0], memo[1]), memo[2]);
    }

}
