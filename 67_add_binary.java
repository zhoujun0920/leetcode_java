class Solution {
  public String addBinary(String a, String b) {
    char[] result;
    if (a.length() > b.length()) {
      result = recursive(a.toCharArray(), b.toCharArray(), 0, 0);
    } else {
      result = recursive(b.toCharArray(), a.toCharArray(), 0, 0);
    }
    return String.valueOf(result);
  }

  private char[] recursive(char[] a, char[] b, int i, int up) {
    if (i == b.length) {
      while (i < a.length) {
        a[a.length - i - 1] += up;
        if (a[a.length - i - 1] > '1') {
          a[a.length - i - 1] -= 2;
        } else {
          up = 0;
          break;
        }
        i++;
      }
      if (up == 1) {
        char[] temp = new char[a.length + 1];
        temp[0] = '1';
        for (int j = 1; j < temp.length; j++) {
          temp[j] = a[j - 1];
        }
        return temp;
      }
      return a;
    }
    a[a.length - i - 1] += (b[b.length - i - 1] - '0' + up);
    if (a[a.length - i - 1] > '1') {
      a[a.length - i - 1] -= 2;
      return recursive(a, b, i + 1, 1);
    } else {
      return recursive(a, b, i + 1, 0);
    }
  }
}


// Input: a = "11", b = "1"
// Output: "100"

// Input: a = "1010", b = "1011"
// Output: "10101"
