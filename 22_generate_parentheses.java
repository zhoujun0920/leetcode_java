class Solution {
  List<String> bt;

  public List<String> generateParenthesis(int n) {
    bt = new ArrayList<>();
    backtrack("", 0, 0, n);
    return bt;
  }

  private void backtrack(String prefix, int open, int close, int n) {
    if (prefix.length() == 2 * n) {
      bt.add(prefix);
      return;
    }
    if (open < n) {
      backtrack(prefix + '(', open + 1, close, n);
    }
    if (close < open) {
      backtrack(prefix + ')', open, close + 1, n);
    }
  }
}
