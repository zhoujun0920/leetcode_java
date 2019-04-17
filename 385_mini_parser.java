class Solution {
    public NestedInteger deserialize(String s) {
        if (s == null || s.length() == 0) {
            return new NestedInteger();
        }
        if (s.charAt(0) == '[') {
            return recursive(s, 1);
        }
        return recursive(s, 0);
    }

    private NestedInteger recursive(String s, int k) {
        char[] sArray = s.toCharArray();
        int number = 0;
        NestedInteger result = new NestedInteger();
        for (int i = k; i < sArray.length; i++) {
            if (Character.isDigit(sArray[i])) {
                number = 10 * number + sArray[i] - '0';
                if (i == sArray.length - 1) {
                    result.setInteger(number);
                }
            } else if (sArray[i] == ',') {
                NestedInteger temp = new NestedInteger(number);
                number = 0;
                result.add(temp);
            } else if (sArray[i] == ']') {
                NestedInteger temp = new NestedInteger(number);
                result.add(temp);
            } else if (sArray[i] == '[') {
                int j = i;
                while (sArray[j] != ']') {
                    j++;
                }
                NestedInteger temp = recursive(s, i + 1);
                i = j + 1;
                result.add(temp);
            }
        }
        return result;
    }
}


class Solution {
    public NestedInteger deserialize(String s) {
      if (s == null && s.length() == 0) {
        return new NestedInteger();
      }
      Stack<NestedInteger> stack = new Stack<>();
      int number = 0;
      int sign = 1;
      for (int i = 0; i < s.length(); i++) {
        if (Character.isDigit(s.charAt(i))) {
          number = 10 * number + s.charAt(i) - '0';
          if (i == s.length() - 1 || s.charAt(i + 1) == ']') {
            if (stack.isEmpty()) {
              stack.push(new NestedInteger(sign * number));
            } else {
              NestedInteger previous = stack.pop();
              previous.add(new NestedInteger(sign * number));
              stack.push(previous);
            }
            number = 0;
            sign = 1;
          }
        } else if (s.charAt(i) == '-') {
          sign = -1;
        } else if (i > 1 && s.charAt(i - 1) != ']' && s.charAt(i) == ',') {
          if (stack.isEmpty()) {
            stack.push(new NestedInteger(sign * number));
          } else {
            NestedInteger previous = stack.pop();
            previous.add(new NestedInteger(sign * number));
            stack.push(previous);
          }
          number = 0;
          sign = 1;
        } else if (s.charAt(i) == '[') {
          stack.push(new NestedInteger());
        } else if (s.charAt(i) == ']') {
          if (stack.size() > 1) {
            NestedInteger previous = stack.pop();
            NestedInteger parent = stack.pop();
            parent.add(previous);
            stack.push(parent);
          }
        }
      }
      if (stack.size() == 1) {
        return stack.pop();
      } else {
        NestedInteger result = new NestedInteger();
        while (!stack.isEmpty()) {
          result.add(stack.pop());
        }
        return result;
      }
    }
}
