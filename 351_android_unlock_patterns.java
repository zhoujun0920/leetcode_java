class Solution {

    int count = 0;

    public int numberOfPatterns(int m, int n) {
      recursive(m, n, i, j, 0);
      return count;
    }

    private void recursive(int m, int n, int x, int y, int i) {
      if (x < 0 || y < 0) {
        return;
      }
      if (i >= m && i <= n) {
        count++;
        return;
      }
      recursive(m, n, x - 1, y - 1, i + 1);
      recursive(m, n, x - 1, y, i + 1);
      recursive(m, n, x - 1, y + 1, i + 1);
      recursive(m, n, x, y - 1, i + 1);
      recursive(m, n, x, y + 1, i + 1);
      recursive(m, n, x + 1, y - 1, i + 1);
      recursive(m, n, x + 1, y, i + 1);
      recursive(m, n, x + 1, y + 1, i + 1);
    }
}
