class Solution {

    HashMap<Integer, List<String>> map = new HashMap<>();

    public List<String> wordBreak(String s, List<String> wordDict) {
        Map<String, Integer> dict = new HashMap<>();
        for (String word : wordDict) {
            dict.put(word, 1);
        }
        return word_Break(s, wordDict, 0, dict);
    }

    public List<String> word_Break(String s, List<String> wordDict, int start, Map<String, Integer> dict) {
        if (map.containsKey(start)) {
            return map.get(start);
        }
        LinkedList<String> res = new LinkedList<>();
        if (start == s.length()) {
            res.add("");
        }
        for (int end = start + 1; end <= s.length(); end++) {
            if (dict.containsKey(s.substring(start, end))) {
                List<String> list = word_Break(s, wordDict, end, dict);
                for (String l : list) {
                    res.add(s.substring(start, end) + (l.equals("") ? "" : " ") + l);
                }
            }
        }
        map.put(start, res);
        return res;
    }
}
