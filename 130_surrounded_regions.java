class Solution {

  int m = 0;
  int n = 0;

  public void solve(char[][] board) {
    m = board.length;
    if (m == 0) {
      return;
    }
    n = board[0].length;
    if (n == 0) {
      return;
    }
    for (int i = 0; i < n; i++) {
      if (board[0][i] == 'O') {
        recursive(board, 0, i);
      }
      if (board[m - 1][i] == 'O') {
        recursive(board, m - 1, i);
      }
    }
    for (int i = 0; i < m; i++) {
      if (board[i][0] == 'O') {
        recursive(board, i, 0);
      }
      if (board[i][n - 1] == 'O') {
        recursive(board, i, n - 1);
      }
    }
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (board[i][j] == 'O') {
          board[i][j] = 'X';
        } else if (board[i][j] == 'Y') {
          board[i][j] = 'O';
        }
      }
    }
  }

  private void recursive(char[][] board, int i, int j) {
    if (i >= 0 && j >= 0 && i < m && j < n && board[i][j] == 'O') {
      board[i][j] = 'Y';
      recursive(board, i + 1, j);
      recursive(board, i - 1, j);
      recursive(board, i, j + 1);
      recursive(board, i, j - 1);
    }
  }
}
