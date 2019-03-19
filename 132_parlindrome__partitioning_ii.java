// TLE
class Solution {
  int m = Integer.MAX_VALUE;
  int bt = 0;

  public int minCut(String s) {
    backtrack(s, 0, 0);
    return m - 1;
  }

  private void backtrack(String s, int start, int l) {
    if (start == s.length()) {
      m = m < bt ? m : bt;
      return;
    }
    for (int i = l; i <= s.length(); i++) {
      if (start + i + 1 > s.length()) {
      return;
    }
      if (isPalindrome(s, start, start + i)) {
        bt++;
        backtrack(s, start + i + 1, 0);
        bt--;
      }
    }
  }

  private boolean isPalindrome(String str, int l, int r) {
    if (l == r) {
      return true;
    }
    while (l < r) {
        if(str.charAt(l++) != str.charAt(r--)) {
          return false;
        }
    }
    return true;
  }
}


class Solution {
  public int minCut(String s) {

  }
}
