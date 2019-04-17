class Solution {

    int m = 0;
    int n = 0;
    int l = 0;

    public int minTotalDistance(int[][] grid) {
      m = grid.length;
      if (m == 0) {
        return 0;
      }
      n = grid[0].length;
      if (n == 0) {
        return 0;
      }
      int[][] memo = new int[m][n];
      for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
          memo[i][j] = Integer.MAX_VALUE;
        }
      }
      for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
          recursive(grid, memo, i, j, 0);
        }
      }
      return l;
    }

    private void recursive(int[][] grid, int[][] memo, int i, int j, int count) {
      if (i >=0 && j >= 0 && i < m && j < n) {
        if (grid[i][j] == 1) {
          if (count < memo[i][j]) {
            if (memo[i][j] != Integer.MAX_VALUE) {
              l -= memo[i][j];
            }
            memo[i][j] =  count;
            l += memo[i][j];
          }
        } else {
          if (memo[i][j] < count) {
            return memo[i][j];
          }
          memo[i][j] = count;
          recursive(grid, memo, i + 1, j, count + 1);
          recursive(grid, memo, i - 1, j, count + 1);
          recursive(grid, memo, i, j + 1, count + 1);
          recursive(grid, memo, i, j - 1, count + 1);
        }
      }
    }
}
