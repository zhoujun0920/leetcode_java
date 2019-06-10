class Solution {
    public List<Integer> partitionLabels(String S) {
        List<Integer> result = new LinkedList<>();
        int[] help = new int[26];
        for (int i = 0; i < S.length(); i++) {
            help[S.charAt(i) - 'a'] = i;
        }
        for (int i = 0; i < S.length(); i++) {
            int m = help[S.charAt(i) - 'a'];
            for (int j = i + 1; j < m; j++) {
                m = m > help[S.charAt(j) - 'a'] ? m : help[S.charAt(j) - 'a'];
            }
            result.add(m - i + 1);
            i = m;
        }
        return result;
    }

}
