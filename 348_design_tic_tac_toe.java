class TicTacToe {

    /** Initialize your data structure here. */

    Map<Integer, Integer> r1;
    Map<Integer, Integer> c1;
    Integer s1;
    Integer s11;
    Map<Integer, Integer> r2;
    Map<Integer, Integer> c2;
    Integer s2;
    Integer s22;
    int N;

    public TicTacToe(int n) {
        N = n;
        r1 = new HashMap<>();
        c1 = new HashMap<>();
        s1 = 0;
        s11 = 0;
        r2 = new HashMap<>();
        c2 = new HashMap<>();
        s2 = 0;
        s22 = 0;
    }

    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int row, int col, int player) {
        if (player == 1) {
            Integer tempRow = r1.getOrDefault(row, 0);
            tempRow++;
            if (tempRow == N) {
                return 1;
            }
            r1.put(row, tempRow);
            Integer tempColumn = c1.getOrDefault(col, 0);
            tempColumn++;
            if (tempColumn == N) {
                return 1;
            }
            c1.put(col, tempColumn);
            if (row == col) {
                s1++;
                if (s1 == N) {
                    return 1;
                }
            }
            if (row == N - col - 1) {
                s11++;
                if (s11 == N) {
                    return 1;
                }
            }
        } else {
            Integer tempRow = r2.getOrDefault(row, 0);
            tempRow++;
            if (tempRow == N) {
                return 2;
            }
            r2.put(row, tempRow);
            Integer tempColumn = c2.getOrDefault(col, 0);
            tempColumn++;
            if (tempColumn == N) {
                return 2;
            }
            c2.put(col, tempColumn);
            if (row == col) {
                s2++;
                if (s2 == N) {
                    return 2;
                }
            }
            if (row == N - col - 1) {
                s22++;
                if (s22 == N) {
                    return 2;
                }
            }
        }
        return 0;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */
