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

class Solution {
  public int countPrimes(int n) {
      if (n <= 2) {
          return 0;
      }
      if (n == 3) {
          return 1;
      }
      if (n == 4) {
          return 2;
      }
      int count = 2;
      int i = 5;
      while (i < n) {
          int j = 2;
          int k = (int)Math.sqrt(i);
          boolean isPrime = true;
          while (j <= k) {
              if (i % j == 0) {
                  isPrime = false;
                  break;
              }
              j++;
          }
          count += (isPrime ? 1 : 0);
          i++;
      }
      return count;
  }
}
