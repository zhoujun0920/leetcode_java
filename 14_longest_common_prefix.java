// Arrays.copyOfRange(char[], begin, length)
// String.valueOf(char[]);
class Solution {
  public String longestCommonPrefix(String[] strs) {
      if (strs.length == 0) {
      return "";
    }
    if (strs.length == 1) {
      return strs[0];
    }
    char[] common = strs[0].toCharArray();
    for (int i = 1; i < strs.length; i++) {
      char[] temp = strs[i].toCharArray();
      int l = temp.length > common.length ? common.length : temp.length;
        if (l == 0) {
      return "";
    }
      for (int j = 0; j < l; j++) {
        if (common[j] == temp[j]) {
            if (j == l - 1) {
          common = temp.length > common.length ? common : temp;
          break;
        }
          continue;
        } else {
          common = Arrays.copyOfRange(common, 0, j);
          if (common.length == 0) {
            return "";
          }
            break;
        }
      }
    }
    return String.valueOf(common);
  }
}
