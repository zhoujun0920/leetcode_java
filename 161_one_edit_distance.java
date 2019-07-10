class Solution {
    public boolean isOneEditDistance(String s, String t) {
        return help(s, 0, t, 0, 1);
    }

    private boolean help(String s, int i, String t, int j, int count) {
        if (count < 0) {
            return false;
        }
        if (s.length() == i && t.length() == j) {
            return count == 0;
        }
        if (s.length() == i) {
            return help(s, i, t, j + 1, count - 1);
        }
        if (t.length() == j) {
            return help(s, i + 1, t, j, count - 1);
        }
        if (s.charAt(i) == t.charAt(j)) {
           return help(s, i + 1, t, j + 1, count);
        }
        return help(s, i + 1, t, j + 1, count - 1) || help(s, i + 1, t, j, count - 1) || help(s, i, t, j + 1, count - 1);
    }
}
