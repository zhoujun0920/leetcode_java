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
     stack.push(-1);
     int m = 0;

     for (int i = 0; i < heights.length; i++) {
       while (stack.peek() != -1 && heights[stack.peek()] > heights[i]) {
         int temp = heights[stack.pop()] * (i - stack.peek() - 1);
         m = m > temp ? m : temp;
       }
       stack.push(i);
     }

     while (stack.peek() != -1) {
       int temp = heights[stack.pop()] * (heights.length - stack.peek() - 1);
       m = m > temp ? m : temp;
     }

     return m;
  }
}


// segment tree

class SegTreeNode {
public:
  int start;
  int end;
  int min;
  SegTreeNode *left;
  SegTreeNode *right;
  SegTreeNode(int start, int end) {
    this->start = start;
    this->end = end;
    left = right = NULL;
  }
};

class Solution {
public:
  int largestRectangleArea(vector<int>& heights) {
    if (heights.size() == 0) return 0;
    // first build a segment tree
    SegTreeNode *root = buildSegmentTree(heights, 0, heights.size() - 1);
    // next calculate the maximum area recursively
    return calculateMax(heights, root, 0, heights.size() - 1);
  }

  int calculateMax(vector<int>& heights, SegTreeNode* root, int start, int end) {
    if (start > end) {
      return -1;
    }
    if (start == end) {
      return heights[start];
    }
    int minIndex = query(root, heights, start, end);
    int leftMax = calculateMax(heights, root, start, minIndex - 1);
    int rightMax = calculateMax(heights, root, minIndex + 1, end);
    int minMax = heights[minIndex] * (end - start + 1);
    return max( max(leftMax, rightMax), minMax );
  }

  SegTreeNode *buildSegmentTree(vector<int>& heights, int start, int end) {
    if (start > end) return NULL;
    SegTreeNode *root = new SegTreeNode(start, end);
    if (start == end) {
        root->min = start;
      return root;
    } else {
      int middle = (start + end) / 2;
      root->left = buildSegmentTree(heights, start, middle);
      root->right = buildSegmentTree(heights, middle + 1, end);
      root->min = heights[root->left->min] < heights[root->right->min] ? root->left->min : root->right->min;
      return root;
    }
  }

  int query(SegTreeNode *root, vector<int>& heights, int start, int end) {
    if (root == NULL || end < root->start || start > root->end) return -1;
    if (start <= root->start && end >= root->end) {
      return root->min;
    }
    int leftMin = query(root->left, heights, start, end);
    int rightMin = query(root->right, heights, start, end);
    if (leftMin == -1) return rightMin;
    if (rightMin == -1) return leftMin;
    return heights[leftMin] < heights[rightMin] ? leftMin : rightMin;
  }
}

class Solution {
    class TreeNode {
      int start;
      int end;
      int min;

      TreeNode left;
      TreeNode right;

      TreeNode(int start, int end) {
        this.start = start;
        this.end = end;
        this.left = null;
        this.right = null;
      }
    }

    private TreeNode buildTree(int[] heights, int start, int end) {
      TreeNode newNode = new TreeNode(start, end);
      if (start == end) {
        newNode.min = start;
        return newNode;
      }
      int mid = start + (end - start) / 2;
      int temp = heights[mid];
      TreeNode left = buildTree(heights, start, mid);
      TreeNode right = buildTree(heights, mid + 1, end);
      newNode.left = left;
      newNode.right = right;
      newNode.min = heights[left.min] > heights[right.min] ? right.min : left.min;
      return newNode;
    }

    public int largestRectangleArea(int[] heights) {
      TreeNode root = buildTree(heights, 0, heights.length - 1);
      return recursive(root, 0, heights.length - 1);
    }

    private int recursive(TreeNode root, int start, int end) {
        if (start > end) {
            return 0;
        }
        if (start == end) {
            return heights[start];
        }

        int m = (end - start + 1) * h;
        return Math.max(Math.max(m, recursive(heights, start, index - 1)), recursive(heights, index + 1, end));
    }
}


// divide and conquer
class Solution {
    public int largestRectangleArea(int[] heights) {
        return recursive(heights, 0, heights.length - 1);
    }

    private int recursive(int[] heights, int start, int end) {
        if (start > end) {
            return 0;
        }
        if (start == end) {
            return heights[start];
        }
        int h = Integer.MAX_VALUE;
        int index = start;
        for (int i = start; i <= end; i++) {
            if (h > heights[i]) {
                h = heights[i];
                index = i;
            }
        }
        int m = (end - start + 1) * h;
        return Math.max(Math.max(m, recursive(heights, start, index - 1)), recursive(heights, index + 1, end));
    }
}

// BF
class Solution {
  public int largestRectangleArea(int[] heights) {
      if (heights.length == 0) {
          return 0;
      }
      int m = Integer.MIN_VALUE;
      for (int i = 0; i < heights.length; i++) {
          int h = Integer.MAX_VALUE;
          for (int j = i; j < heights.length; j++) {
              h = h < heights[j] ? h : heights[j];
              int temp = (j - i + 1) * h;
              m = m > temp ? m : temp;
          }
      }
      return m;
  }
}
