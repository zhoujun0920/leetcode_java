class Solution {
    public int[] plusOne(int[] digits) {
      int up = 1;
      for (int i = digits.length - 1; i >= 0; i--) {
        if (up == 1) {
          digits[i] += 1;
        }
        if (digits[i] > 9) {
          up = 1;
          digits[i] -= 10;
        } else {
            return digits;
        }
      }
      int[] temp = new int[digits.length + 1];
      temp[0] = 1;
      for (int i = 1; i < temp.length; i++) {
        temp[i] = digits[i - 1];
      }
      return temp;
    }
}
