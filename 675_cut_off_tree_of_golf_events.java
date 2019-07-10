class Solution {
    int row;
    int column;
    TreeMap<Integer, int[]> tm;

    public int cutOffTree(List<List<Integer>> forest) {
        row = forest.size();
        column = forest.get(0).size();
        tm = new TreeMap<>();
        boolean[][] memo = new boolean[row][column];
        int[] start = {0, 0};
        help(forest, start, memo);
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (forest.get(i).get(j) > 0 && !memo[i][j]) {
                    return -1;
                }
            }
        }
        int total = 0;
        for(Map.Entry<Integer, int[]> entry : tm.entrySet()) {
            int[] end = entry.getValue();
            total += shortestWay(forest, start, end);
            start = end;
        }
        return total;
    }

    private int shortestWay(List<List<Integer>> forest, int[] start, int[] end) {
        Queue<int[]> queue = new LinkedList<>();
        Queue<Integer> distanceQueue = new LinkedList<>();
        boolean[][] memo = new boolean[row][column];
        int[][] ds = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        queue.add(start);
        memo[start[0]][start[1]] = true;
        distanceQueue.add(0);
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int distance = distanceQueue.poll();
            if (current[0] == end[0] && current[1] == end[1]) {
                return distance;
            }
            for (int[] d : ds) {
                int[] next = {current[0] + d[0], current[1] + d[1]};
                if (isVisit(forest, next) && !memo[next[0]][next[1]]) {
                    queue.add(next);
                    memo[next[0]][next[1]] = true;
                    distanceQueue.add(distance + 1);
                }
            }
        }
        return 0;
    }

    private void help(List<List<Integer>> forest, int[] start, boolean[][] memo) {
        if (memo[start[0]][start[1]]) {
            return;
        }
        memo[start[0]][start[1]] = true;
        tm.put(forest.get(start[0]).get(start[1]), start);
        int[][] ds = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int[] d : ds) {
            int[] next = {start[0] + d[0], start[1] + d[1]};
            if (isVisit(forest, next)) {
                help(forest, next, memo);
            }
        }
    }

    private boolean isVisit(List<List<Integer>> forest, int[] start) {
        return start[0] >= 0 && start[0] < row && start[1] >= 0 && start[1] < column && forest.get(start[0]).get(start[1]) != 0;
    }
}
