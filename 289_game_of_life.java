// & bitwise
// && logical
// 00 dead <- dead
// 01 dead <- live
// 10 live <- dead
// 11 live <- live
// 00 & 1 get 1st bit
// 00 >> 1 get 2nd bit

class Solution {
    public void gameOfLife(int[][] board) {
      int m = board.length;
      if (m > 0) {
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
          for (int j = 0; j < n; j++) {
            int count = 0;
            if (i - 1 >= 0) {
              if (j - 1 >= 0) {
                count += board[i - 1][j - 1] & 1;
              }
              count += board[i - 1][j] & 1;
              if (j + 1 < n) {
                count += board[i - 1][j + 1] & 1;
              }
            }
            if (j - 1 >= 0) {
              count += board[i][j - 1] & 1;
            }
            if (j + 1 < n) {
              count += board[i][j + 1] & 1;
            }
            if (i + 1 < m) {
              if (j - 1 >= 0) {
                count += board[i + 1][j - 1] & 1;
              }
              count += board[i + 1][j] & 1;
              if (j + 1 < n) {
                count += board[i + 1][j + 1] & 1;
              }
            }
            board[i][j] = getPoint(count, board[i][j]);
          }
        }
        for (int i = 0; i < m; i++) {
          for (int j = 0; j < n; j++) {
            int temp = board[i][j];
            board[i][j] = temp >> 1;
          }
        }
      }
    }

    private int getPoint(int count, int origin) {
      if (count < 2) {
        return origin == 0 ? 0 : 1;
      } else if (count <= 3) {
        if (count == 3) {
          return origin == 0 ? 2 : 3;
        }
        return origin == 0 ? 0 : 3;
      }
      return origin == 0 ? 0 : 1;
    }
}
