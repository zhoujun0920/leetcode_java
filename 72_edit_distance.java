// "abbc" "acc"

// same "c" in the end, no changes
// "abb" "ac"
// replace "abc" "ac" -> "ab" "a"
// delete "ab" "ac"
// insert "abbc" "ac" -> "abb" "a"

class Solution {
    public int minDistance(String word1, String word2) {
      int l1 = word1.length();
      int l2 = word2.length();
      Integer[][] memo = new Integer[l1 + 1][l2 + 1];
      return recursive(word1, word2, l1, l2, memo);
    }

    private int recursive(String word1, String word2, int l1, int l2, Integer[][] memo) {
      if (l1 == 0) {
        return l2;
      }
      if (l2 == 0) {
        return l1;
      }
      if (memo[l1][l2] != null) {
        return memo[l1][l2];
      }
      int ans;
      if (word1.charAt(l1 - 1) == word2.charAt(l2 - 1)) {
        // no changes
        ans = recursive(word1, word2, l1 - 1, l2 - 1, memo);
      } else {
        // min of replace, insert, delete
        ans = Math.min(recursive(word1, word2, l1 - 1, l2 - 1, memo), Math.min(recursive(word1, word2, l1 - 1, l2, memo), recursive(word1, word2, l1, l2 - 1, memo))) + 1;
      }
      return memo[l1][l2] = ans;
    }
}
