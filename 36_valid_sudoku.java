class Solution {

    public boolean isValidSudoku(char[][] board) {
      HashMap<Integer, Integer>[] row = new HashMap[9];
      HashMap<Integer, Integer>[] column = new HashMap[9];
      HashMap<Integer, Integer>[] box = new HashMap[9];
      for (int i = 0; i < 9; i++) {
        row[i] = new HashMap<Integer, Integer>();
        column[i] = new HashMap<Integer, Integer>();
        box[i] = new HashMap<Integer, Integer>();
      }
      for (int i = 0; i < 9; i++) {
        for (int j = 0; j < 9; j++) {
          if (board[i][j] != '.') {
            int temp = board[i][j] - '0';
            row[i].put(temp, row[i].getOrDefault(temp, 0) + 1);
            column[j].put(temp, column[j].getOrDefault(temp, 0) + 1);
            int b = i / 3 * 3 + j / 3;
            box[b].put(temp, box[b].getOrDefault(temp, 0) + 1);
            if (row[i].get(temp) > 1 || column[j].get(temp) > 1 || box[b].get(temp) > 1)
              return false;
            }
          }
        }
        return true;
    }
}
