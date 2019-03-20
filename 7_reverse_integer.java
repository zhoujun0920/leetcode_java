class Solution {
  public int reverse(int x) {
    boolean isNegative = false;
    if (x < 0) {
      isNegative = true;
    }
    String s = String.valueOf(x);
    char[] sArray = s.toCharArray();
    int result = 0;
    for (int k = sArray.length - 1; k >= (isNegative ? 1 : 0); k--) {
        int temp = result;
      result = result * 10 + sArray[k] - '0';
        if ((result - sArray[k] + '0') / 10 != temp) {
            return 0;
        }
    }
    return isNegative ? -result : result;
  }
}
