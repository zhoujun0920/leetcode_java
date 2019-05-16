class WordDictionary {

    class TreeNode {

        char value;
        boolean end;
        TreeNode[] children;

        TreeNode(char val, boolean isEnd) {
            value = val;
            end = isEnd;
            children = new TreeNode[26];
        }
    }

    TreeNode root;

    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TreeNode(' ', false);
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TreeNode current = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (current.children[index] == null) {
                TreeNode temp = new TreeNode(word.charAt(i), (i == word.length() - 1));
                current.children[index] = temp;
            }
            current = current.children[index];
        }
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return recursive(word, root);
    }

    private boolean recursive(String word, TreeNode current) {
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == '.') {
                for (int j = 0; j < 26; j++) {
                    if (current.children[j] != null) {
                        if (recursive(word.substring(i + 1), current.children[j])) {
                            return true;
                        }
                    }
                }
                return false;
            } else {
                int index = word.charAt(i) - 'a';
                if (current.children[index] == null) {
                    return false;
                }
                current = current.children[index];
            }
        }
        return current.end;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
