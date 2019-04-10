class Solution {
  public int[][] generateMatrix(int n) {
      int[][] m = new int[n][n];
      int count = 1;
      for (int i = 0; i < n - i; i++) {
          count = matrixHelp(m, i, n, count);
      }
      return m;
  }

  private int matrixHelp(int[][] m, int k, int n, int count) {
      for (int i = k; i < n - k; i++) {
          m[k][i] = count++;
      }
      for (int i = k + 1; i < n - k - 1; i++) {
          m[i][n - k - 1] = count++;
      }
      if (n - k - 1 != k) {
          for (int i = n - k - 1; i >= k; i--) {
              m[n - k - 1][i] = count++;
          }
          for (int i = n - k - 2; i > k; i--) {
              m[i][k] = count++;
          }
      }
      return count;
  }
}
