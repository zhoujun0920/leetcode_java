class Solution {

    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
          return 0;
        }
        return recursive(coins, amount, new int[amount + 1]);
    }

    private int recursive(int[] coins, int amount, int[] memo) {
        if (amount < 0) {
          return -1;
        }
        if (amount == 0) {
          return 0;
        }
        if (memo[amount] != 0) {
          return memo[amount];
        }
        int temp = Integer.MAX_VALUE;
        for (int coin : coins) {
          int changes = recursive(coins, amount - coin, memo);
          if (changes >= 0 && changes < temp) {
            temp = changes + 1;
          }
        }
        memo[amount] = temp == Integer.MAX_VALUE ? -1 : temp;
        return memo[amount];
    }
}


// TLE
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
                return count + 1;
              }
            }
          }
          queue.addAll(current);
          count++;
        }
        return -1;
    }
}



// TLE
class Solution {

    public int coinChange(int[] coins, int amount) {
      if (amount == 0) {
          return 0;
      }
      return recursive(coins, amount, 0, new int[amount]);
    }

    private int recursive(int[] coins, int amount, int count, int[] memo) {
        if (count >= total) {
            return count;
        }
        if (amount == 0){
            return count;
        }
        int total = Integer.MAX_VALUE;
        for (int i = coins.length - 1; i >= 0; i--) {
            int target = amount - coins[i];
            if (target >= 0) {
                int temp = recursive(coins, target, count + 1, memo);
                if (temp > 0 && temp < total) {
                    total = temp;
                }
            }
        }
        return -1;
    }
}


class Solution {
  public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        Arrays.sort(coins);
        return recursive(coins, amount, 0);
    }

    private int recursive(int[] coins, int amount, int count) {
        if (amount == 0){
            return count;
        }
        for (int i = coins.length - 1; i >= 0; i--) {
            int target = amount - coins[i];
            if (target >= 0) {
                int temp = recursive(coins, target, count + 1);
                if (temp > 0) {
                    return temp;
                }
            }
        }
        return -1;
    }
}

class Solution {

    int count;

    public int coinChange(int[] coins, int amount) {
      if (amount == 0) {
        return 0;
      }
      Arrays.sort(coins);
      recursive(coins, amount, 0, coins.length - 1);
      return count;
    }

    private boolean recursive(int[] coins, int amount, int current, int index) {
      if (current > amount) {
        return false;
      }
      if (current == amount) {
        return true;
      }
      current += coins[index];
      count++;
      if (recursive(coins, amount, current, index)) {
        return true;
      }
      current -= coins[index];
      count--;
      return recursive(coins,amount, current, index - 1);
    }
}
