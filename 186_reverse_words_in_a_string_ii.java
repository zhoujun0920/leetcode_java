class Solution {
  public void reverseWords(char[] str) {
    if (str.length == 0) {
        return;
    }
    List<String> temp = new ArrayList<>();
      int i = 0;
      while (i < str.length) {
          String t = "";
          while (i < str.length && str[i] != ' ') {
              t += String.valueOf(str[i]);
              i++;
          }
          temp.add(t);
          i++;
      }
      i = str.length - 1;
      int j = 0;
      while (j >= 0) {
          String t = temp.get(j);
          char[] tArray = t.toCharArray();
          for (int k = tArray.length - 1; k >=0; k--) {
              str[i] = tArray[k];
              i--;
          }
          if (i == -1) {
              break;
          }
          str[i] = ' ';
          i--;
          j++;
      }
  }
}

// reverse in place
// 1, reverse the whole sentence
// 2, reverse each word
// 3, reverse the last word, if there is only one word this will solve the corner case
class Solution {
  public void reverseWords(char[] s) {
      reverse(s, 0, s.length - 1);
      int start = 0;
      int end = -1;
      for (int i = 0; i < s.length; i++) {
          if (s[i] == ' ') {
              reverse(s, start, i - 1);
              start = i + 1;
          }
      }
      reverse(s, start, s.length - 1);
  }

  public void reverse(char[] s, int start, int end) {
      while (start < end) {
          char temp = s[start];
          s[start] = s[end];
          s[end] = temp;
          start++;
          end--;
      }
  }
}
