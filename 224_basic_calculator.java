class Solution {
    public int calculate(String s) {
        Stack<String> stack = new Stack<>();
        char[] sArray = s.toCharArray();
        for (int i = 0; i < sArray.length; i++) {
            if (sArray[i] == ' ') {
                continue;
            }
            if (sArray[i] != ')') {
                stack.push(String.valueOf(sArray[i]));
            } else {
                String temp = "";
                while (!stack.peek().equals("(")) {
                    temp = stack.pop() + temp;
                }
                stack.pop();
                String result = help(temp);
                stack.push(result);
            }
        }
        String t = "";
        while (!stack.isEmpty()) {
            t = stack.pop() + t;
        }
        return Integer.valueOf(help(t));
    }

    private String help(String s) {
        char[] sArray = s.toCharArray();
        int result = 0;
        boolean flag = true;
        for (int i = 0; i < sArray.length; i++) {
            if (sArray[i] == '-') {
                flag = !flag;
                continue;
            }
            int temp = 0;
            while (i < sArray.length && Character.isDigit(sArray[i])) {
                temp = 10 * temp + sArray[i] - '0';
                i++;
            }
            result += (flag ? 1 : -1) * temp;
            if (i >= sArray.length) {
                return String.valueOf(result);
            }
            flag = sArray[i] != '-';
        }
        return String.valueOf(result);
    }
}


class Solution {
    public int calculate(String s) {
      Stack<Integer> stack = new Stack<Integer>();
      int result = 0;
      int number = 0;
      int sign = 1;
      for(int i = 0; i < s.length(); i++){
          char c = s.charAt(i);
          if(Character.isDigit(c)){
              number = 10 * number + (int)(c - '0');
          }else if(c == '+'){
              result += sign * number;
              number = 0;
              sign = 1;
          }else if(c == '-'){
              result += sign * number;
              number = 0;
              sign = -1;
          }else if(c == '('){
              //we push the result first, then sign;
              stack.push(result);
              stack.push(sign);
              //reset the sign and result for the value in the parenthesis
              sign = 1;
              result = 0;
          }else if(c == ')'){
              result += sign * number;
              number = 0;
              result *= stack.pop();    //stack.pop() is the sign before the parenthesis
              result += stack.pop();   //stack.pop() now is the result calculated before the parenthesis

          }
      }
      if(number != 0) result += sign * number;
      return result;
    }
}
