// A -> 1
// AZ -> 52
// Z -> 26
class Solution {
  public int titleToNumber(String s) {
      return recursive(s, 0, 0);
  }

  private int recursive(String s, int total, int i) {
      int l = s.length();
      char[] cArray = s.toCharArray();
      if (l == 1) {
          return total + (cArray[0] - 'A' + 1) * (int)Math.pow(26, i);
      }
      char t = cArray[l - 1];
      total += (t - 'A' + 1) * (int)Math.pow(26, i);
      cArray[l - 1] = ' ';
      return recursive(String.valueOf(cArray).trim(), total, i + 1);
  }
}
