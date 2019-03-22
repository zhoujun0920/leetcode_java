class Solution {
    public boolean isPowerOfThree(int n) {
      if (n == 0) {
        return false;
      }
      if (n == 1) {
        return true;
      }
      int x = 3;
      while (n % 3 == 0) {
        while (n % x == 0) {
          n /= x;
          if (n == 1) {
            return true;
          }
          x *= x;
        }
        x *= 3;
      }
      return false;
    }
}
