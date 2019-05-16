class Solution {
  public boolean isMatch(String s, String p) {
     return recursive(s, 0, p, 0, new Boolean[s.length()][p.length()]);
 }

  private boolean recursive(String s, int index1, String p, int index2, Boolean[][] memo) {
     if (index1 == s.length() && index2 == p.length()) {
         return true;
     }
      if (index1 >= s.length() || index2 >= p.length()) {
          if (index2 < p.length() - 1 && p.charAt(index2 + 1) == '*') {
              return recursive(s, index1, p, index2 + 2, memo);
          }
          return false;
      }
     if (memo[index1][index2] != null) {
         return memo[index1][index2];
     }
     if (s.charAt(index1) == p.charAt(index2) || p.charAt(index2) == '.') {
         if (index2 < p.length() - 1 && p.charAt(index2 + 1) == '*') {
             if (recursive(s, index1 + 1, p, index2, memo)) {
               return memo[index1][index2] = true;
             }
             return memo[index1][index2] = recursive(s, index1, p, index2 + 2, memo);
         } else {
             return memo[index1][index2] = recursive(s, index1 + 1, p, index2 + 1, memo);
         }
     } else {
         if (index2 < p.length() - 1 && p.charAt(index2 + 1) == '*') {
             return memo[index1][index2] = recursive(s, index1, p, index2 + 2, memo);
         }
     }
     return memo[index1][index2] = false;
 }
}


class Solution {
  public boolean isMatch(String s, String p) {
      return recursive(s, s.length() - 1, p, p.length() - 1);
  }

   private boolean recursive(String s, int index1, String p, int index2) {
      if (index1 <= -1 && index2 <= -1) {
          return true;
      }
       if (index1 <= -1 || index2 <= -1) {
           if (index2 >= 0 && index2 < p.length() - 1 && p.charAt(index2 + 1) == '*') {
               return recursive(s, index1, p, index2 - 2);
           }
           return false;
       }
       if (p.charAt(index2) == '*') {
         return recursive(s, index1, p, index2 - 1);
       }

      if (s.charAt(index1) == p.charAt(index2) || p.charAt(index2) == '.') {
          if (index2 < p.length() - 1 && p.charAt(index2 + 1) == '*') {
              return recursive(s, index1 - 1, p, index2);
          } else {
              return recursive(s, index1 - 1, p, index2 - 1);
          }
      } else {
          if (index2 < p.length() - 1 && p.charAt(index2 + 1) == '*') {
              return recursive(s, index1, p, index2 - 1);
          }
      }
      return false;
  }
}
