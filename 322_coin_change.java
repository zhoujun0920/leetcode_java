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
