class Solution {
  public int evalRPN(String[] tokens) {
    Stack<Integer> stack = new Stack<>();
    for (int i = 0; i < tokens.length; i++) {
        if (isOperator(tokens[i])) {
          Integer second = stack.pop();
          Integer first = stack.pop();
          if (tokens[i].equals("+")) {
            stack.push((first + second));
          } else if (tokens[i].equals("-")) {
            stack.push((first - second));
          } else if (tokens[i].equals("*")) {
            stack.push((first * second));
          } else if (tokens[i].equals("/")) {
            stack.push((first / second));
          }
        } else {
          int temp = help(tokens[i]);
          stack.push(temp);
        }
    }
    return stack.pop();
  }

  private boolean isOperator(String s) {
    if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
      return true;
    }
    return false;
  }

  private int help(String s) {
    boolean flag = true;
    int result = 0;
    char[] sArray = s.toCharArray();
    if (sArray[0] == '-') {
      flag = false;
    }
    for (int i = flag ? 0 : 1; i < sArray.length; i++) {
      result = 10 * result + sArray[i] - '0';
    }
    return flag ? result : -result;
  }
}
