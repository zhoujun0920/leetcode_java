// monostack
// 5 3 1 2 4
// -1 3 1 1 -1

class Solution {

    public int[] largerCount(int[] array) {
      int n = array.length;
      int[] result = new int[n];
      for (int i = 0; i < n; i++) {
        result[i] = -1;
      }
      Stack<Integer> stack = new Stack<>();
      for (int i = 0; i < n; i++) {
        if (!stack.isEmpty() && array[stack.peek()] < array[i]) {
          int index= stack.pop();
          result[index] = i - index;
        }
        stack.push(i);
      }
      return result;
    }
}



// monostack
class Solution {
    public int largestRectangleArea(int[] heights) {
      Stack<Integer> stack = new Stack<>();

    }
}
