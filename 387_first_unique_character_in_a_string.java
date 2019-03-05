class Solution {
    public int firstUniqChar(String s) {
       HashMap<String, Integer> hm = new HashMap<>();
       for (int i = 0; i < s.length(); i++) {
         String temp = String.valueOf(s.charAt(i));
         if (hm.containsKey(temp)) {
           hm.put(temp, hm.get(temp) + 1);
         } else {
           hm.put(temp, 1);
         }
       }
       for (int i = 0; i < s.length(); i++) {
         String temp = String.valueOf(s.charAt(i));
         if (hm.get(temp) == 1) {
           return i;
         }
       }
       return -1;
    }
}

//LinkedHashMap will maintain the order to insert element
class Solution {
    public int firstUniqChar(String s) {

    }
}
