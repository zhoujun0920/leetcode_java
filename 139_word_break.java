


class Solution {
    Boolean[] memo;
    Map<String, Integer> dict;

    public boolean wordBreak(String s, List<String> wordDict) {
      dict = new HashMap<>();
      memo = new Boolean[s.length()];
      for (String t : wordDict) {
        dict.put(t, 1);
      }
      return recursive("", s, 0);
    }

    private boolean recursive(String prefix, String s, int i) {
      if (s.length() == 0 && dict.containsKey(prefix)) {
        return true;
      }
      if (s.length() == 0) {
        return false;
      }
      if (memo[i] != null) {
        return memo[i];
      }
      prefix += s.charAt(0);
      if (dict.containsKey(prefix)) {
        memo[i] = recursive("", s.substring(1), i + 1) || recursive(prefix, s.substring(1), i + 1);
        return memo[i];
      }
      memo[i] = recursive(prefix, s.substring(1), i + 1);
      return memo[i];
    }
}

// Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
// Output: false


public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        return word_Break(s, new HashSet(wordDict), 0, new Boolean[s.length()]);
    }
    public boolean word_Break(String s, Set<String> wordDict, int start, Boolean[] memo) {
        if (start == s.length()) {
            return true;
        }
        if (memo[start] != null) {
            return memo[start];
        }
        for (int end = start + 1; end <= s.length(); end++) {
            if (wordDict.contains(s.substring(start, end)) && word_Break(s, wordDict, end, memo)) {
                return memo[start] = true;
            }
        }
        return memo[start] = false;
    }
}

// DP
// catsandog

public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordDictSet=new HashSet(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
