class Solution {
    public String decodeString(String s) {
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ']') {
                stack.push(s.charAt(i));
                continue;
            }
            StringBuilder temp = new StringBuilder();
            while (!stack.isEmpty() && stack.peek() != '[') {
                temp.insert(0, stack.pop());
            }
            stack.pop();
            StringBuilder count = new StringBuilder();
            while (!stack.isEmpty() && stack.peek() >= '0' && stack.peek() <= '9') {
                count.insert(0, stack.pop());
            }
            for (int j = 0; j < Integer.valueOf(count.toString()); j++) {
                for (int k = 0; k < temp.length(); k++) {
                    stack.push(temp.charAt(k));
                }
            }
        }
        while (!stack.isEmpty()) {
            result.insert(0, stack.pop());
        }
        return result.toString();
    }
}
