class Solution {
    public boolean isPowerOfTwo(int n) {
      if (n == 1) {
        return true;
      }
      int x = 2;
      while (n != 1) {
        while (n % x == 0) {
          n /= x;
          if (n == 1) {
            return true;
          }
          x *= 2;
        }
        x = 2;
      }
      return false;
    }
}
