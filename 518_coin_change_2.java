class Solution {
    public int coinChange(int[] coins, int amount) {
        int count = 0;
        if (amount == 0) {
          return count;
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.add(amount);
        while (!queue.isEmpty()) {
          Queue<Integer> current = new LinkedList<>();
          while (!queue.isEmpty()) {
            int temp = queue.poll();
            for (int coin : coins) {
              if (temp - coin > 0) {
                current.add(temp - coin);
              }
              if (temp - coin == 0) {
                count++;
              }
            }
          }
          queue.addAll(current);
        }
        return count;
    }
}

// DP
class Solution {
    public int change(int amount, int[] coins) {
        int[][] memo = new int[coins.length + 1][amount + 1];
        memo[0][0] = 1;
        for (int i = 1; i < amount + 1; i++) {
            memo[0][i] = 0;
        }
        for (int i = 1; i < coins.length + 1; i++) {
            memo[i][0] = 1;
        }
        for (int i = 1; i < coins.length + 1; i++) {
            for (int j = 1; j < amount + 1; j++) {
                if (j - coins[i - 1] >= 0) {
                    memo[i][j] = memo[i][j - coins[i - 1]] + memo[i - 1][j];
                } else {
                    memo[i][j] = memo[i - 1][j];
                }
            }
        }
        return memo[coins.length][amount];
    }
}
