class Solution {
    public String decodeString(String s) {
      Stack<Character> stack = new Stack<>();
      char[] sArray = s.toCharArray();
      String result = "";
      for (int i = 0; i < sArray.length; i++) {
        char c = sArray[i];
        if (c <= '9' && c >= '0') {
          stack.push(c);
        }
        int sum = 0;
        while (!stack.isEmpty()) {
          char temp = stack.pop();
          sum = 10 * sum + temp - '0';
        }
        int j = i + 1;
        String temp = "";
        while (sArray[j] != ']') {
          temp += sArray[j];
        }
        for (int k = 0; k < sum; k++) {
          result += temp;
        }
      }
      return result;
    }
}


class Solution {
    public String decodeString(String s) {
      Stack<Character> stack = new Stack<>();
      char[] sArray = s.toCharArray();
      String result = "";
      for (int i = 0; i < sArray.length; i++) {
        if (sArray[i] != ']') {
          stack.push(sArray[i]);
        }
        String tempString = "";
        while (stack.peek() != '[') {
          tempString = stack.pop() + tempString;
        }
        String num = "";
        while (stack.peek() <= '9' && stack.peek() >= '0') {
          num = stack.pop() + num;
        }
      }
    }
}
