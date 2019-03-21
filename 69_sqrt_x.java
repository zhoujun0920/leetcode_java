class Solution {
  public int mySqrt(int x) {
    if (x < 2) {
      return x;
    }
    return sqrt(x, 1);
  }

  private int sqrt(int x, int y) {
    if (x / y > y) {
      while (x / y > y) {
        y *= 2;
      }
      return sqrt(x, y);
    } else if (x / y == y) {
      return y;
    } else {
      int low = y / 2;
      int high = y;
      while (low < high - 1) {
        int mid = (low + high) / 2;
        if (x / mid == mid) {
          return mid;
        } else if (x / mid < mid) {
          high = mid;
        } else {
          low = mid;
        }
      }
      return low;
    }
  }
}
