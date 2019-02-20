class Solution {
    public String getHint(String secret, String guess) {
      String result = "";
      String[] s = secret.split("");
      String[] g = guess.split("");
      HashMap<String, Integer> ss = new HashMap<>();
      HashMap<String, Integer> rh = new HashMap<>();
      HashMap<Integer, Integer> position = new HashMap<>();
      for (int i = 0; i < s.length; i++) {
        if (s[i].equals(g[i]) {
          position.put(i, 1);
          if (rh.containsKey("A")) {
            Integer n = rh.get("A");
            rh.put("A", n + 1);
          } else {
            rh.put("A", 1);
          }
        } else {
          if (ss.containsKey(s[i])) {
            Integer n = ss.get(s[i]);
            ss.put(s[i], n + 1);
          } else {
            ss.put(s[i], 1);
          }
        }
      }
      for (int i = 0; i < s.length; i++) {
        if (!position.containsKey(i)) {
          if (ss.containsKey(g[i])) {
            Integer n = ss.get(g[i]);
            if (n == 1) {
              ss.remove(g[i]);
            } else {
              Integer m = ss.get(g[i]);
              ss.put(g[i], m - 1);
            }
            if (rh.containsKey("B")) {
              Integer m = rh.get("B");
              rh.put("B", m + 1);
            } else {
              rh.put("B", 1);
            }
          }
        }
      }
      if (rh.containsKey("A")) {
        result = String.valueOf(rh.get("A")) + "A";
      } else {
        result = "0A";
      }
      if (rh.containsKey("B")) {
        result = result + String.valueOf(rh.get("B")) + "B";
      } else {
        result += "0B";
      }
      return result;
    }
}

class Solution {
    public String getHint(String secret, String guess) {
      int b = 0;
      int c = 0;
      int[] n = new int[10];
      for (int i = 0; i < secret.length(); i++) {
        int s = Character.getNumericValue(secret.charAt(i));
        int g = Character.getNumericValue(guess.charAt(i));
        if (s == g) {
          bull++;
        } else {
          if (n[s] < 0) {
            c++;
          }
          if (n[g] > 0) {
            c++;
          }
          n[s]++;
          n[g]--;
        }
      }
      return b + "A" + c + "B";
    }
}
