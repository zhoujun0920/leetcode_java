class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
      if (s1.length() + s2.length() != s3.length()) {
        return false;
      }
    }

    private boolean recursive(String s1, int l1, String s2, int l2, String s3, String current) {
      if (current == s3) {
        return true;
      }
      
    }
}

// aabcc
// dbbca
// a
