class Solution {
      int m = 0;
      int n = 0;

      public void wallsAndGates(int[][] rooms) {
        m = rooms.length;
        if (m == 0) {
          return;
        }
        n = rooms[0].length;
        if (n == 0) {
          return;
        }
        for (int i = 0; i < m; i++) {
              for (int j = 0; j < n; j++) {
                  if (rooms[i][j] == 0) {
                      recursive(rooms, i, j, 0);
                  }
              }
          }
      }

      private void recursive(int[][] rooms, int i, int j, int count) {

        if (i < 0 || j < 0 || i >= m || j >= n || rooms[i][j] < 0 || rooms[i][j] < count) {
               return;
        }
          rooms[i][j] = count;
          recursive(rooms, i + 1, j, count + 1);
          recursive(rooms, i - 1, j, count + 1);
          recursive(rooms, i, j + 1, count + 1);
          recursive(rooms, i, j - 1, count + 1);
      }
  }
}
