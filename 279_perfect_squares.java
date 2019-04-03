
// TLE
class Solution {

  int m = Integer.MAX_VALUE;

  public int numSquares(int n) {
    recursive(n, 0);
    return m;
  }

  private void recursive(int n, int count) {
    if (n < 0) {
      return;
    }
    if (n == 0) {
      m = m > count ? count : m;
      return;
    }
    for (int i = (int)Math.floor(Math.sqrt(n)); i >= 1; i--) {
      recursive(n - i * i, count + 1);
    }
  }
}

//DP
// dp[0] = 0
// dp[1] = 1
// dp[2] = 2
// dp[3] = 3
// dp[4] = dp[4 - 1^2] + 1, dp[4 - 2^2] + 1
// dp[5] = dp[5 - 1^2] + 1, dp[5 - 2^2] + 1
// ...
// dp[11] = dp[11 - 1] + 1, dp[11 - 2^2] + 1, dp[11 - 3^2] + 1

class Solution {

    public int numSquares(int n) {
      if (n < 4) {
        return n;
      }
      int[] dp = new int[n + 1];
      dp[0] = 0;
      dp[1] = 1;
      dp[2] = 2;
      dp[3] = 3;
      for (int i = 4; i <= n; i++) {
        int j = 2;
        int temp = dp[i - 1] + 1;
        while (i - j * j >= 0) {
          temp = temp > dp[i - j * j] ? dp[i - j * j] + 1 : temp;
          j++;
        }
        dp[i] = temp;
      }
      return dp[n];
    }

}
