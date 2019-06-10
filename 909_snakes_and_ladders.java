class Solution {
    public int snakesAndLadders(int[][] board) {
        int N = board.length;
        Queue<Integer> queue = new LinkedList<>();
        Map<Integer, Integer> dict = new HashMap();
        dict.put(1, 0);
        queue.add(1);
        while (!queue.isEmpty()) {
            int index = queue.poll();
            int height = dict.get(index);
            if (index == N * N) {
                return height;
            }
            for (int i = index + 1; i <= Math.min(index + 6, N * N); i++) {
                int[] cor = getCor(i, N);
                int temp = 0;
                if (board[cor[0]][cor[1]] == -1) {
                    temp = i;
                } else {
                    temp = board[cor[0]][cor[1]];
                }
                if (!dict.containsKey(temp)) {
                    dict.put(temp, height + 1);
                    queue.add(temp);
                }
            }
        }
        return -1;
    }

    private int[] getCor(int index, int N) {
        int x = N - (index - 1) / N - 1;
        int y = x % 2 != N % 2 ? (index - 1) % N : N - (index - 1) % N - 1;
        int[] result = {x, y};
        return result;
    }
}

class Solution {
    public int snakesAndLadders(int[][] board) {
        int N = board.length;

        Map<Integer, Integer> dist = new HashMap();
        dist.put(1, 0);

        Queue<Integer> queue = new LinkedList();
        queue.add(1);

        while (!queue.isEmpty()) {
            int s = queue.remove();
            if (s == N*N) return dist.get(s);

            for (int s2 = s+1; s2 <= Math.min(s+6, N*N); ++s2) {
                int rc = get(s2, N);
                int r = rc / N, c = rc % N;
                int s2Final = board[r][c] == -1 ? s2 : board[r][c];
                if (!dist.containsKey(s2Final)) {
                    dist.put(s2Final, dist.get(s) + 1);
                    queue.add(s2Final);
                }
            }
        }
        return -1;
    }

    public int get(int s, int N) {
        // Given a square num s, return board coordinates (r, c) as r*N + c
        int quot = (s-1) / N;
        int rem = (s-1) % N;
        int row = N - 1 - quot;
        int col = row % 2 != N % 2 ? rem : N - 1 - rem;
        return row * N + col;
    }
}
