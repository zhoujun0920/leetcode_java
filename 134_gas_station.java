class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
      for (int i = 0; i < gas.length; i++) {
        if (gas[i] >= cost[i]) {
          int start = i;
          int t = gas[start] - cost[start];
          boolean isFailed = false;
          if (start + 1 < gas.length) {
            for (int j = start + 1; j < gas.length; j++) {
              t = t + gas[j] - cost[j];
              if (t < 0) {
                isFailed = true;
                i = j;
                break;
              }
            }
          }
          if (!isFailed) {
            for (int j = 0; j < start; j++) {
              t = t + gas[j] - cost[j];
              if (t < 0) {
                isFailed = true;
                break;
              }
            }
            if (!isFailed) {
              return start;
            }
          }
        }
      }
      return -1;
    }
}
