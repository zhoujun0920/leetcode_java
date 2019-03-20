class Solution {
    public boolean isSubsequence(String s, String t) {
      char[] sArray = s.toCharArray();
      char[] tArray = t.toCharArray();
      if (sArray.length == 0) {
            return true;
      }
      int i = 0;
      int j = 0;
      while (i < sArray.length) {
        if (sArray[i] == tArray[j]) {
          j++;
          if (j >= tArray.length) {
            return true;
          }
        }
        i++;
      }
      return false;
    }
}
