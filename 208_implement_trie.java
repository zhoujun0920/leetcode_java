class Trie {

    class TreeNode {

        char val;
        boolean end;
        Map<Character, TreeNode> children;

        TreeNode(char c, boolean isEnd) {
            val = c;
            end = isEnd;
            children = new HashMap<Character, TreeNode>();
        }
    }

    TreeNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TreeNode(' ', false);
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TreeNode current = root;
        for (int i = 0; i < word.length(); i++) {
            if (current.children.containsKey(word.charAt(i))) {
                current = current.children.get(word.charAt(i));
                if (i == word.length() - 1 && !current.end) {
                    current.end = true;
                }
            } else {
                TreeNode temp;
                if (i == word.length() - 1) {
                    temp = new TreeNode(word.charAt(i), true);
                } else {
                    temp = new TreeNode(word.charAt(i), false);
                }
                current.children.put(word.charAt(i), temp);
                current = temp;
            }
        }
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TreeNode current = root;
        for (int i = 0; i < word.length(); i++) {
            if (current.children.containsKey(word.charAt(i))) {

                current = current.children.get(word.charAt(i));
            } else {
                return false;
            }
        }
        if (current.end) {
            return true;
        }
        return false;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TreeNode current = root;
        for (int i = 0; i < prefix.length(); i++) {
            if (current.children.containsKey(prefix.charAt(i))) {
                current = current.children.get(prefix.charAt(i));
            } else {
                return false;
            }
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */



// Using array is faster
 class Trie {

    class TreeNode {

        char val;
        boolean end;
        TreeNode[] children;

        TreeNode(char c, boolean isEnd) {
            val = c;
            end = isEnd;
            children = new TreeNode[26];
        }
    }

    TreeNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TreeNode(' ', false);
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TreeNode current = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (current.children[index] != null) {
                current = current.children[index];
                if (i == word.length() - 1 && !current.end) {
                    current.end = true;
                }
            } else {
                TreeNode temp;
                if (i == word.length() - 1) {
                    temp = new TreeNode(word.charAt(i), true);
                } else {
                    temp = new TreeNode(word.charAt(i), false);
                }
                current.children[index] = temp;
                current = temp;
            }
        }
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TreeNode current = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (current.children[index] != null) {
                current = current.children[index];
            } else {
                return false;
            }
        }
        if (current.end) {
            return true;
        }
        return false;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TreeNode current = root;
        for (int i = 0; i < prefix.length(); i++) {
            int index = prefix.charAt(i) - 'a';
            if (current.children[index] != null) {
                current = current.children[index];
            } else {
                return false;
            }
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
