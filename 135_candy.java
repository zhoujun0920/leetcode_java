class Solution {
    public int candy(int[] ratings) {
      int count = 0;
      int n = ratings.length;
      if (n == 0) {
        return count;
      }
      count = n;
      int previous = 1;
      for (int i = 1; i < n; i++) {
        if (ratings[i] <= ratings[i - 1]) {
            previous = 1;
          int j = i - 1;
          while (j > 0) {
            if (ratings[j] < ratings[j - 1]) {
              count++;
                break;
            }
            j--;
          }
        } else {
            count = count + previous + 1;
            previous = previous + 1;
        }
      }
      return count;
    }
}
