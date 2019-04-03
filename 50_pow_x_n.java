class Solution {
  public double myPow(double x, int n) {
		if (n == 0) {
			return 1;
		}
        if (x == 1) {
			return 1;
		}
		if (n > 0) {
			return recursive(x, n, 1);
		} else {
			double result = recursive(x, -(long)n, 1);
			return 1 / result;
		}
	}

	private double recursive(double x, long n, double total) {
		if (n == 1) {
			return total * x;
		}
		long i = 1;
		double result = x;
		while (i + i < n) {
			i += i;
			result *= result;
		}
		return recursive(x, n - i, total * result);
	}
}
