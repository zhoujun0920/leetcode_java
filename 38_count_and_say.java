class Solution {
  public String countAndSay(int n) {
      return countRecursive("1", 1, n);
  }

  private String countRecursive(String t, int k, int n) {
      if (k == n) {
          return t;
      }
      char[] tArray = t.toCharArray();
      char current = tArray[0];
      int count = 1;
      String tt = "";
      if (tArray.length == 1) {
          tt += String.valueOf(count) + String.valueOf(current);
      }
      for (int i = 1; i < tArray.length; i++) {
          if (tArray[i] == current) {
              count++;
              if (i == tArray.length - 1) {
                  tt += String.valueOf(count) + String.valueOf(current);
              }
          } else {
              tt += String.valueOf(count) + String.valueOf(current);
              count = 1;
              current = tArray[i];
              if (i == tArray.length - 1) {
                  tt += String.valueOf(count) + String.valueOf(current);
              }
          }
      }
      return countRecursive(tt, k + 1, n);
  }
}
