class Solution {
  public double myPow(double x, int n) {
    return pow(x, n, 1, 0);
  }

  private double pow(double x, int n, double y, int i) {
    if (y * y < x) {
      while (y * y < x) {
        y *= 2;
        i += i;
      }
      return pow(x, n, y, i);
    } else if (y * y == x) {
      return i + i;
    } else {

    }
  }
}
