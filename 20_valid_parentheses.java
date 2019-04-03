class Solution {
    public boolean isValid(String s) {
      Stack<Character> stack = new Stack<Character>();
      for(char c : s.toCharArray()) {
        if (c == ')' || c == ']' || c == '}') {
          if (stack.size() == 0) {
            return false;
          }
          Character temp = stack.pop();
          if ((c == ')' && !temp.equals('(')) || (c == ']' && !temp.equals('[')) || (c == '}' && !temp.equals('{'))) {
            return false;
          }
        } else {
          stack.push(c);
        }
      }
      return stack.size() == 0;
    }
}
