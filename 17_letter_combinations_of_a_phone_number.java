class Solution {
   List<String> results;

   public List<String> letterCombinations(String digits) {
     Map<Character, List<Character>> hm = new HashMap<>();
     List<Character> c2 = Arrays.asList('a', 'b', 'c');
     hm.put('2', c2);
     List<Character> c3 = Arrays.asList('d', 'e', 'f');
     hm.put('3', c3);
     List<Character> c4 = Arrays.asList('g', 'h', 'i');
     hm.put('4', c4);
     List<Character> c5 = Arrays.asList('j', 'k', 'l');
     hm.put('5', c5);
     List<Character> c6 = Arrays.asList('m', 'n', 'o');
     hm.put('6', c6);
     List<Character> c7 = Arrays.asList('p', 'q', 'r', 's');
     hm.put('7', c7);
     List<Character> c8 = Arrays.asList('t', 'u', 'v');
     hm.put('8', c8);
     List<Character> c9 = Arrays.asList('w', 'x', 'y', 'z');
     hm.put('9', c9);
     results = new LinkedList<>();
     recursive("", digits.toCharArray(), 0, hm);
     return results;
   }

   private void recursive(String prefix, char[] c, int i, Map<Character, List<Character>> hm) {
       if (i >= c.length) {
           return;
       }
       int index = prefix.length();
       Character key = c[index];
       List<Character> cList = hm.get(key);
       if (prefix.length() == c.length - 1) {
         for (int l = 0; l < cList.size(); l++) {
             results.add(prefix + String.valueOf(cList.get(l)));
         }
       return;
       }
       for (int l = 0; l < cList.size(); l++) {
         recursive(prefix + String.valueOf(cList.get(l)), c, 0, hm);
       }
   }
}
