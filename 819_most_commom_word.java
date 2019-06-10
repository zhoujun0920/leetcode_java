class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> set = new HashSet<>();
        for (String s : banned) {
            set.add(s.toLowerCase());
        }
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < paragraph.length(); i++) {
            String word = "";
            while (i < paragraph.length() && paragraph.charAt(i) != ' '
            && paragraph.charAt(i) != '!' && paragraph.charAt(i) != '?'
            && paragraph.charAt(i) != '\'' && paragraph.charAt(i) != ','
            && paragraph.charAt(i) != ';' && paragraph.charAt(i) != '.') {
                word += Character.toLowerCase(paragraph.charAt(i));
                i++;
            }
                if (!word.equals("") && !set.contains(word)) {
                    Integer count = map.getOrDefault(word, 0);
                    map.put(word, ++count);
                }

        }
        String result = "";
        int m = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > m) {
                result = entry.getKey();
                m = entry.getValue();
            }
        }
        return result;
    }
}
