class Solution {
    public int countPrimes(int n) {
      boolean[] temp = new boolean[n];
      int count = 0;
      for (int i = 2; i < n; i++) {
        if (temp[i - 1]) {
          count++;
          for (int j = 2; j * i < n; j++) {
            temp[j * i - 1] = false;
          }
        }
      }
      return count;
    }
}


class Solution {
  public boolean isPrime(int n) {
    double temp = Math.sqrt(n);
    for (int i = 2; i < n; i++) {
      if (n % i == 0) {
        return false;
      }
    }
    return true;
  }
}
