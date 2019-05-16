class Solution {
    public boolean isMatch(String s, String p) {
        return recursive(s, 0, p, 0, new Boolean[s.length()][p.length()]);
    }

    private boolean recursive(String s, int index1, String p, int index2, Boolean[][] memo) {
        if (index1 >= s.length() && index2 >= p.length()) {
            return true;
        }
        if (index1 >= s.length() || index2 >= p.length()) {
            if (index2 <= p.length() - 1 && p.charAt(index2) == '*') {
                return recursive(s, index1, p, index2 + 1, memo);
            }
            return false;
        }
        if (memo[index1][index2] != null) {
            return memo[index1][index2];
        }
        if (s.charAt(index1) == p.charAt(index2) || p.charAt(index2) == '?') {
            return memo[index1][index2] = recursive(s, index1 + 1, p, index2 + 1, memo);
        } else {
            if (p.charAt(index2) == '*') {
                for (int i = index1 + 1; i <= s.length(); i++) {
                    if (recursive(s, i, p, index2, memo)) {
                        return memo[index1][index2] = true;
                    }
                }
                if (recursive(s, index1, p, index2 + 1, memo)) {
                    return memo[index1][index2] = true;
                }
            }
        }
        return memo[index1][index2] = false;
    }
}

// DP Need to take a look at it.
public class Solution {
    public boolean isMatch(String s, String p) {
        boolean[][] match=new boolean[s.length()+1][p.length()+1];
        match[s.length()][p.length()]=true;
        for(int i=p.length()-1;i>=0;i--){
            if(p.charAt(i)!='*')
                break;
            else
                match[s.length()][i]=true;
        }
        for(int i=s.length()-1;i>=0;i--){
            for(int j=p.length()-1;j>=0;j--){
                if(s.charAt(i)==p.charAt(j)||p.charAt(j)=='?')
                        match[i][j]=match[i+1][j+1];
                else if(p.charAt(j)=='*')
                        match[i][j]=match[i+1][j]||match[i][j+1];
                else
                    match[i][j]=false;
            }
        }
        return match[0][0];
    }
}
