class Solution {
  static int m = 0;
  static int n = 0;

  static boolean found = false;

  public static boolean exist(char[][] board, String word) {
      m = board.length;
      if (m == 0) {
          return false;
      }
      n = board[0].length;
      if (n == 0) {
          return false;
      }
      List<Character> wordList = new LinkedList<>();
      int[][] memo = new int[m][n];
      for (char c : word.toCharArray()) {
          wordList.add(c);
      }
      for (int i = 0; i < m; i++) {
          for (int j = 0; j < n; j++) {
              if (wordList.get(0).equals(board[i][j])) {
                  backtracking(board, memo, i, j, wordList);
                  if (found) {
                      return true;
                  }
              }
          }
      }
      return false;
  }

  private static void backtracking(char[][] board, int [][] memo, int i, int j, List<Character> word) {
      if (found) {
          return;
      }
      if (i < m && j < n) {
          if (word.get(0).equals(board[i][j])) {
              word.remove(0);
              memo[i][j] = 1;
              if (word.isEmpty()) {
                  found = true;
                  return;
              }
              if (i + 1 < m && memo[i + 1][j] == 0) {
                  backtracking(board, memo, i + 1, j, word);
              }
              if (i - 1 >= 0 && memo[i - 1][j] == 0) {
                  backtracking(board, memo, i - 1, j, word);
              }
              if (j + 1 < n && memo[i][j + 1] == 0) {
                  backtracking(board, memo, i, j + 1, word);
              }
              if (j - 1 >= 0 && memo[i][j - 1] == 0) {
                  backtracking(board, memo, i, j - 1, word);
              }
              memo[i][j] = 0;
              word.add(0, board[i][j]);
          }
      }
  }
}


class Solution {
     int m = 0;
     int n = 0;

     boolean found = false;

    public boolean exist(char[][] board, String word) {
        m = board.length;
        if (m == 0) {
            return false;
        }
        n = board[0].length;
        if (n == 0) {
            return false;
        }
        int[][] memo = new int[m][n];
        char[] w = word.toCharArray();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (w[0] == board[i][j]) {
                    backtracking(board, memo, i, j, w, 0);
                    if (found) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private void backtracking(char[][] board, int [][] memo, int i, int j, char[] word, int cur) {
        if (found) {
            return;
        }
        if (i < m && j < n) {
            if (word[cur] == board[i][j]) {
                memo[i][j] = 1;
                if (cur == word.length - 1) {
                    found = true;
                    return;
                }
                if (i + 1 < m && memo[i + 1][j] == 0) {
                    backtracking(board, memo, i + 1, j, word, cur + 1);
                }
                if (i - 1 >= 0 && memo[i - 1][j] == 0) {
                    backtracking(board, memo, i - 1, j, word, cur + 1);
                }
                if (j + 1 < n && memo[i][j + 1] == 0) {
                    backtracking(board, memo, i, j + 1, word, cur + 1);
                }
                if (j - 1 >= 0 && memo[i][j - 1] == 0) {
                    backtracking(board, memo, i, j - 1, word, cur + 1);
                }
                memo[i][j] = 0;
            }
        }
    }
}
