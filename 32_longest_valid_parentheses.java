class Solution {
  public int longestValidParentheses(String s) {
		if (s.length() < 2) {
			return 0;
		}
		Stack<Character> stack = new Stack<>();
		int i = 0;
		int j = 0;
		int m = 0;
		int temp = 0;
		char[] sArray = s.toCharArray();
		while (j < sArray.length) {
			if (stack.size() == 0) {
				if (sArray[j] == '(') {
					i = j;
					stack.add('(');
					j++;
					continue;
				}
				m = m > temp ? m : temp;
				temp = 0;
			} else {
				if (sArray[j] == '(') {
					stack.add('(');
				} else {
					stack.pop();
					if (stack.size() == 0) {
						temp += j - i + 1;
						m = m > temp ? m : temp;
					}
				}
			}
			j++;
			if (j == sArray.length && j - i > m && stack.size() > 0) {
				stack.clear();
				j = i + 1;
				temp = 0;
			}
		}
		return m;
	}
}


class Solution {
  public int longestValidParentheses(String s) {
    int maxans = 0;
    Stack<Integer> stack = new Stack<>();
    stack.push(-1);
    for (int i = 0; i < s.length(); i++) {
        if (s.charAt(i) == '(') {
            stack.push(i);
        } else {
            stack.pop();
            if (stack.empty()) {
                stack.push(i);
            } else {
                maxans = Math.max(maxans, i - stack.peek());
            }
        }
    }
    return maxans;
  }
}
