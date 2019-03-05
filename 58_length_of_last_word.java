class Solution {
    public int lengthOfLastWord(String s) {
      char[] sArray = s.trim().toCharArray();
      int l = 0;
      for (int i = sArray.length - 1; i >= 0; i--) {
        if (sArray[i] == ' ') {
          return l;
        } else {
          l++;
        }
      }
      return l;
    }
}

// s.charAt();
class Solution {
    public int lengthOfLastWord(String s) {
      int l = 0;
      for (int i = s.length() - 1; i >=0; i--) {
        if (l == 0 && s.charAt(i) == ' ') {
          continue;
        }
        if (s.charAt(i) == ' ') {
          return l;
        }
        l++;
      }
      return l;
    }
}
