class Solution {
    public boolean exist(char[][] board, String word) {
      List<Character> word = new LinkedList<>();
      int[][] memo = new int[board.length][board[0].length];
      for (char c in word.toCharArray()) {
        word.add(c);
      }

    }

    private boolean backtracking(char[][] board, int i, int j, List<Character> word) {
      if (word.isEmpty()) {
        return true;
      }
      if (i < n && j < m) {
        if (word.contains(board[i][j])) {
          word.remove(board[i][j]);
          backtracking(board, i + 1, j, word);
          backtracking(board, )
        }
      }
    }
}
