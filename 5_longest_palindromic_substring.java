class Solution {
  public String longestPalindrome(String s) {
        if (s.length() < 2) {
            return s;
        }
        String m = s.substring(0, 1);
        String temp;
        for (int i = 0; i < s.length() - 1; i++) {
            temp = lpr(s, i, i + 1, 0);
            if (m.length() < temp.length()) {
                m = temp;
            }
            temp = lpr(s, i - 1, i + 1, 1);
            if (m.length() < temp.length()) {
                m = temp;
            }
        }
        return m;
    }

    private String lpr(String s, int start, int end, int ms) {
        if (start >= 0 && end <= s.length() - 1) {
            if (s.charAt(start) == s.charAt(end)) {
                return lpr(s, start - 1, end + 1, ms + 2);
            }
        }
        if (start + 1 < end - 1) {
            return s.substring(start + 1, end);
        }
        return "";
    }
}


class Solution {
    public String longestPalindrome(String s) {
        if (s.length() <= 1) {
            return s;
        }
        String m = s.substring(0, 1);
        for (int i = 0; i < s.length() - 1; i++) {
            String temp1 = help(s, i - 1, i + 1);
            String temp2 = help(s, i, i + 1);
            if (m.length() < temp1.length()){
                m = temp1;
            }
            if (m.length() < temp2.length()){
                m = temp2;
            }
        }
        return m;
    }

    private String help(String s, int start, int end) {
        while (start >=0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            start--;
            end++;
        }
        return s.substring(start + 1, end);
    }
}
// Input: "babad"
// Output: "bab"

// Input: "cbbd"
// Output: "bb"
