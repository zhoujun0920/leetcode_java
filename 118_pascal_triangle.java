// unable to handle numRows > 18, stack over flow
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
          result.add(coefficient(i));
        }
        return result;
    }

    private List<Integer> coefficient(int num) {
      List<Integer> result = new ArrayList<>();
        for (int i = 0; i <= num / 2; i++) {
                result.add(combination(num, i));
            }
        if (num % 2 == 0) {
            for (int i = num / 2 - 1; i >=0; i--) {
                result.add(result.get(i));
            }
        } else {
            for (int i = num / 2; i >=0; i--) {
                result.add(result.get(i));
            }
        }
      return result;
    }

    private int combination(int n, int m) {
      int result = 1;
      if (m == 0 || m == n) {
        return result;
      }
      if (m == 1) {
          return n;
      }
      for (int i = n; i > n - m; i--) {
        result *= i;
      }
      for (int i = 1; i <= m; i++) {
        result /= i;
      }
      return result;
    }
}

//dynamic programming
class Solution {
    public List<List<Integer>> generate(int numRows) {
      List<List<Integer>> result = new ArrayList<>();
      generate(result, new ArrayList(), 0, numRows);
      return result;

    }

    public void generate(List<List<Integer>> result, List<Integer> previous, int n, int numRows) {
      if (n > numRows) {
        return;
      }
      List<Integer> row = new ArrayList<>();
      for (int i = 0; i <= n; i++) {
        if (i == 0 || i == n) {
          row.add(1);
        } else {
          if (previous.size() > 0) {
            Integer temp = previous.get(i - 1) + previous.get(i);
            row.add(temp);
          }
        }
      }
      result.add(row);
      generate(result, row, n + 1, numRows);
    }

}
