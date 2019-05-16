// DP
class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        if (n == 0) {
            return 0;
        }
        int[] dp = new int[n + 1];
        dp[0] = 1; // empty string has 1 way to decode
        dp[1] = s.charAt(0) != '0' ? 1 : 0;
        for (int i = 2; i <= n; i++) {
            int temp1 = s.charAt(i - 1) - '0';
            int temp2 = (s.charAt(i - 2) - '0') * 10 + s.charAt(i - 1) - '0';
            if (temp1 > 0) {
                dp[i] += dp[i - 1];
            }
            if (temp2 >= 10 && temp2 <= 26) {
                dp[i] += dp[i - 2];
            }
        }

        return dp[n];
    }
}


class Solution {
    public int numDecodings(String s) {
      return recursive(s, 0, new Integer[s.length()]);
    }

    private int recursive(String s, int index, Integer[] memo) {
      if (index >= s.length()) {
           return 1;
       }
      if (memo[index] != null) {
          return memo[index];
      }
      int num = 0;
      if (s.charAt(index) != '0') {
          num += recursive(s, index + 1, memo);
      }
      if (index < s.length() - 1) {
          int temp = (s.charAt(index) - '0') * 10 + s.charAt(index + 1) - '0';
          if (temp >= 10 && temp <= 26) {
              num += recursive(s, index + 2, memo);
          }
      }
      return memo[index] = num;
    }
}
