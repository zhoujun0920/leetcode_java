class Solution {
    int result = 0;

    public int depthSum(List<NestedInteger> nestedList) {
        recursive(nestedList, 1);
        return result;
    }

    private void recursive(List<NestedInteger> nestedList, int level) {
        for (NestedInteger n : nestedList) {
            if (n.isInteger()) {
                result += n.getInteger() * level;
            } else {
                recursive(n.getList(), level + 1);
            }
        }
    }
}
