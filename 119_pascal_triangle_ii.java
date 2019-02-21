//long 64bits
//int 32bits
//short 16bits
//float 32 bits 8 bits for exponent, 23 bits fraction, 1 bit sign
//double 64 bits 11 bits for exponent, 52 bits fraction, 1 bit sign
class Solution {
    public List<Integer> getRow(int rowIndex) {
        return generate(new ArrayList(), 0, rowIndex);
    }

    public List<Integer> generate(List<Integer> previous, int n, int numRows) {
      if (n > numRows) {
        return previous;
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
      return generate(row, n + 1, numRows);
    }
}
