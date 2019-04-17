class Solution {
    int m = 0;
    int n = 0;

    public int numIslands(char[][] grid) {
      m = grid.length;
      if (m == 0) {
        return 0;
      }
      n = grid[0].length;
      if (n == 0) {
        return 0;
      }
      int l = 0;
      for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
          if (grid[i][j] == '1') {
            grid[i][j] == '0';
            l++;
            recursive(grid, i, j);
          }
        }
      }
      return l;
    }

    private void recursive(char[][] grid, int i, int j) {
      if (i >= 0 && j >= 0 && i < m && j < n) {
        if (i > 0 && grid[i - 1][j] == '1') {
          grid[i - 1][j] = '0';
          recursive(grid, i - 1, j);
        }
        if (i < m - 1 && grid[i + 1][j] == '1') {
          grid[i + 1][j] = '0';
          recursive(grid, i + 1, j);
        }
        if (j > 0 && grid[i][j] == '1') {
          grid[i][j - 1] = '0';
          recursive(grid, i, j - 1);
        }
        if (j < n - 1 && grid[i][j] == '1') {
          grid[i][j + 1] = '0';
          recursive(grid, i, j + 1);
        }
      }
    }
}
