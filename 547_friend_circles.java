class Solution {

  public int findCircleNum(int[][] M) {
    int N = M.length;
    if (N == 0) {
      return 0;
    }
    int[] parents = new int[N];
    Arrays.fill(parents, -1);
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        if (i != j && M[i][j] == 1) {
          int x = help(parents, i);
          int y = help(parents, j);
          if (x == y) {
            continue;
          }
          parents[x] = y;
          M[j][i] = 0;
        }
      }
    }
    int total = 0;
    for (int p : parents) {
      if (p == -1) {
        total++;
      }
    }
    return total;
  }

  private int help(int[] parents, int n) {
    if (parents[n] == -1) {
      return n;
    }
    return help(parents, parents[n]);
  }
}

class Solution {

    int N;
    int[][] ds;

    public int findCircleNum(int[][] M) {
      N = M.length;
      if (N == 0) {
        return 0;
      }
      int total = 0;
      ds = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
      for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
          if (M[i][j] == 1) {
            int[] start = {i, j};
            help(M, start);
            total++;
          }
        }
      }
      return total;
    }

    private void help(int[][] M, int[] start) {
      M[start[0]][start[1]] = 0;
      for (int[] d : ds) {
        int[] next = {start[0] + d[0], start[1] + d[1]};
        if (isVisit(M, next)) {
          help(M, next);
        }
      }
    }

    private boolean isVisit(int[][] M, int[] start) {
      return start[0] >= 0 && start[0] < N && start[1] >= 0 && start[1] < N && M[start[0]][start[1]] == 1;
    }
}
