// BF
// TLE
class Solution {
    int m;
    int n;

    public int minPathSum(int[][] grid) {
      m = grid.length;
      if (m == 0) {
        return 0;
      }
      n = grid[0].length;
      if (n == 0) {
        return 0;
      }
      return recursive(grid, 0, 0);
    }

    private int recursive(int[][] grid, int i, int j) {
      if (i >= m || j >= n) {
        return Integer.MAX_VALUE;
      }
      if (i == m - 1 && j == n - 1) {
        return grid[i][j];
      }
      return grid[i][j] + Math.min(recursive(grid, i + 1, j), recursive(grid, i, j + 1));
    }
}

// DP
// from bottom to top
class Solution {
    public int minPathSum(int[][] grid) {
      int m = grid.length;
      if (m == 0) {
        return 0;
      }
      int n = grid[0].length;
      if (n == 0) {
        return 0;
      }
      int[][] dp = new int[m][n];
      for (int i = m - 1; i >= 0; i--) {
        for (int j = n - 1; j >= 0; j--) {
          if (i == m - 1 && j == n - 1) {
            dp[i][j] = grid[i][j];
          } else if (i == m - 1) {
            dp[i][j] = dp[i][j + 1] + grid[i][j];
          } else if (j == n - 1) {
            dp[i][j] = dp[i + 1][j] + grid[i][j];
          } else {
            dp[i][j] = Math.min(dp[i][j + 1], dp[i + 1][j]) + grid[i][j];
          }
        }
      }
      return dp[0][0];
    }
}

// DP
// from top to bottom

class Solution {
    public int minPathSum(int[][] grid) {
      int m = grid.length;
      if (m == 0) {
        return 0;
      }
      int n = grid[0].length;
      if (n == 0) {
        return 0;
      }
      int[][] dp = new int[m][n];
      for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
          if (i == 0 && j == 0) {
            dp[i][j] = grid[i][j];
          } else if (i == 0) {
            dp[i][j] = dp[i][j - 1] + grid[i][j];
          } else if (j == 0) {
            dp[i][j] = dp[i - 1][j] + grid[i][j];
          } else {
            dp[i][j] = Math.min(dp[i][j - 1], dp[i - 1][j]) + grid[i][j];
          }
        }
      }
      return dp[m - 1][n - 1];
    }
}
