class Solution {
    public boolean isPerfectSquare(int num) {
      long n = 1;
      while (n * n < num) {
        if (n * n == num) {
          return true;
        }
        n *= 2;

      }
      long low = n / 2;
      long high = n;
      while (low < high - 1) {
        long mid = (low + high) / 2;
        if (mid * mid == num) {
          return true;
        } else if (mid * mid < num) {
          low = mid;
        } else {
          high = mid;
        }
      }
      return false;
    }
}
