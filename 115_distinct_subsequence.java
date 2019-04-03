// TLE
class Solution {
  int m = 0;

  public int numDistinct(String s, String t) {
    recursive(s, t, 0, 0);
    return m;
  }

  private void recursive(String s, String t, int i, int j) {
    if (j >= t.length()) {
      m++;
      return;
    }
    if (i < s.length() && s.charAt(i) == t.charAt(j)) {
      recursive(s, t, i + 1, j + 1);
    }
    if (i + 1 < s.length()) {
      recursive(s, t, i + 1, j);
    }
  }
}

// Input: S = "rabbbit", T = "rabbit"
// Output: 3
