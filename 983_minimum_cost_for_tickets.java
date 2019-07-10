class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int[] dp = new int[days[days.length - 1] + 1];
        boolean[] travel = new boolean[dp.length];
        for (int i = 0; i < days.length; i++) {
            travel[days[i]] = true;
        }
        for (int i = 1; i < dp.length; i++) {
            if (travel[i]) {
               int t1 = dp[i - 1] + costs[0];
               int t7 = dp[Math.max(0, i - 7)] + costs[1];
               int t30 = dp[Math.max(0, i - 30)] + costs[2];
               dp[i] = Math.min(Math.min(t1, t7), t30);
            } else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[dp.length - 1];
    }
}
