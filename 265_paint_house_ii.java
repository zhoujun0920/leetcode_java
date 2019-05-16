class Solution {
    public int minCostII(int[][] costs) {
        int n = costs.length;
        if (n == 0) {
        return 0;
      }
        int m = costs[0].length;

        if (m == 0) {
            return 0;
        }
      int min1 = -1;
      int min2 = -1;
      int position1 = -1;
      for (int i = 0; i < m; i++) {
        if (min1 == -1 || costs[0][i] < min1) {
          min2 = min1;
          min1 = costs[0][i];
          position1 = i;
        } else if (min2 == -1 || costs[0][i] < min2) {
          min2 = costs[0][i];
        }
      }
      for (int i = 1; i < n; i++) {
        int temp1 = min1;
        int temp2 = min2;
        int tempPosition1 = position1;
        min1 = -1;
        min2 = -1;
        position1 = -1;
        for (int j = 0; j < m; j++) {
          int current1;
          if (j == tempPosition1) {
            current1 = costs[i][j] + temp2;
          } else {
            current1 = costs[i][j] + temp1;
          }
          if (min1 == -1 || current1 < min1) {
            min2 = min1;
            min1 = current1;
            position1 = j;
          } else if (min2 = -1 || current1 < min2) {
            min2 = current1;
          }
        }
      }
      return min1;
    }
}
