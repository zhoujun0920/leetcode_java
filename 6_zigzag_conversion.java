class Solution {
  public String convert(String s, int numRows) {
     int l = s.length();
      if (l <= 1 || numRows <= 1) {
          return s;
      }
      int p = numRows * 2 - 2;
      int c = l / p * 2;
      int extra = l % p;
      if (extra > numRows) {
          c += 2;
      } else if (extra > 0) {
          c += 1;
      }
      char[][] temp = new char[numRows][c];
      char[] sArray = s.toCharArray();
      int index = 0;
      for (int i = 0; i < c; i++) {
         if (i % 2 == 0) {
              for (int j = 0; j < numRows; j++) {
                  if (index < l) {
                      temp[j][i] = sArray[index];
                      index++;
                  } else {
                      temp[j][i] = '*';
                  }
              }
          } else {
              for (int j = numRows - 1; j >= 0; j--) {
                  if (j == 0 || j == numRows - 1 || index >= l) {
                      temp[j][i] = '*';
                  } else {
                      temp[j][i] = sArray[index];
                      index++;
                  }
              }
          }
      }
      String result = "";
      for (int i = 0; i < numRows; i++) {
          for (int j = 0; j < c; j++) {
              if (temp[i][j] != '*') {
                  result += String.valueOf(temp[i][j]);
              }
          }
      }
      return result;
  }
}
