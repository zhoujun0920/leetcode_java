class Solution {
     List<String> results;

     public List<String> restoreIpAddresses(String s) {
       results = new LinkedList<>();

       recursive("", s, "", 0, 0);
       return results;
     }

     private void recursive(String prefix, String str, String current, int i, int sum) {
         if (str.length() > 0) {
             if (current.length() == 1 && current.charAt(0) == '0') {
                 return;
             }
             if (i > 3) {
                 return;
             }
             if (sum * 10 + Integer.valueOf(str.charAt(0) - '0') > 255) {
                 return;
             }
             if (i == 3 && str.length() == 1) {
                 results.add(prefix + str);
                 return;
             }
             recursive(prefix + str.charAt(0), str.substring(1), current + str.charAt(0),  i, sum * 10 + Integer.valueOf(str.charAt(0) - '0'));
             recursive(prefix + str.charAt(0) + ".", str.substring(1), "", i + 1, 0);
         }
     }
   }
}
