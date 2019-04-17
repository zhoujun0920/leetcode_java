class Solution {

    int result = 0;

    public int depthSumInverse(List<NestedInteger> nestedList) {
      int height = recursiveHeight(nestedList);
      recursive(nestedList, height);
      return result;
    }

    private void recursive(List<NestedInteger> nestedList, int level) {
      for (NestedInteger n : nestedList) {
        if (n.isInteger()) {
          result += level * n.getInteger();
        } else {
          recursive(n.getList(), level - 1);
        }
      }
    }

    private int recursiveHeight(List<NestedInteger> nestedList) {
      if (nestedList == null) {
        return 1;
      }
      int h = 0;
      for (NestedInteger n : nestedList) {
        int temp = recursiveHeight(n.getList());
        h = h > temp ? h : temp;
      }
      return h + 1;
    }
}
