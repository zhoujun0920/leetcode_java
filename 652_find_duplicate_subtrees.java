class Solution {

    Map<String, Integer> map;
    List<TreeNode> result;

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        result = new LinkedList<>();
        map = new HashMap<>();
        help(root);
        return result;
    }

    private String help(TreeNode root) {
        if (root == null) {
            return "n";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(root.val);
        sb.append(help(root.left));
        sb.append(help(root.right));
        String key = sb.toString();
        Integer count = map.getOrDefault(key, 0);
        map.put(key, count + 1);
        if (map.get(key) == 2) {
            result.add(root);
        }
        return key;
    }
}
