class Solution {
  public List<Integer> findSubstring(String s, String[] words) {
    List<Integer> results = new ArrayList<>();
		Map<String, Integer> windowCopy = new HashMap<>();
		Map<String, Integer> remainCopy = new HashMap<>();
		Map<String, Integer> window = new HashMap<>();
		Map<String, Integer> remain = new HashMap<>();
		int count = 0;
		for (String ss : words) {
			if (window.containsKey(ss)) {
				windowCopy.put(ss, windowCopy.get(ss) + 1);
				window.put(ss, window.get(ss) + 1);
			} else {
				windowCopy.put(ss, 1);
				window.put(ss, 1);
				remain.put(ss, 1);
				remainCopy.put(ss, 1);
				count = ss.length();
			}
		}
		char[] sArray = s.toCharArray();
		int startIndex = 0;
		int i = 0;
		while (i <= sArray.length - count) {
			String tempS = getS(sArray, i, count);
			if (window.containsKey(tempS)) {
				int res = window.get(tempS) - 1;
				window.put(tempS, res);
				if (res <= 0) {
					if (res == 0) {
						remain.remove(tempS);
						if (remain.keySet().size() == 0) {
							results.add(startIndex);
							window.putAll(windowCopy);
							remain.putAll(remainCopy);
							i = startIndex + 1;
							startIndex = i;
							continue;
						}
					} else {
						window.putAll(windowCopy);
						remain.putAll(remainCopy);
						i = startIndex + 1;
						startIndex = i;
						continue;
					}
				}
				i += count;
			} else {
				i = startIndex + 1;
				startIndex = i;
				window.putAll(windowCopy);
				remain.putAll(remainCopy);
			}
		}
		return results;
  }

  private String getS(char[] sArray, int startIndex, int count) {
    char[] temp = new char[count];
    for (int j = 0; j < count; j++) {
      temp[j] = sArray[startIndex + j];
    }
    return String.valueOf(temp);
  }
}

// s = "barfoothefoobarman",
// words = ["foo","bar"]
// Output: [0,9]

// s = "wordgoodgoodgoodbestword",
// words = ["word","good","best","word"]
// Output: []

class Solution {
  public List<Integer> findSubstring(String s, String[] words) {
    List<Integer> results = new ArrayList<>();
		Map<String, Integer> window = new HashMap<>();
		Map<String, Integer> remain = new HashMap<>();
		int count = 0;
		for (String ss : words) {
			if (window.containsKey(ss)) {
				window.put(ss, window.get(ss) + 1);
			} else {
				window.put(ss, 1);
				remain.put(ss, 1);
				count = ss.length();
			}
		}
		char[] sArray = s.toCharArray();
		int startIndex = 0;
		int i = 0;
		while (i <= sArray.length - count) {
			String tempS = getS(sArray, i, count);
			if (window.containsKey(tempS)) {
				int res = window.get(tempS) - 1;
				window.put(tempS, res);
				if (res <= 0) {
					if (res == 0) {
						remain.remove(tempS);
						if (remain.keySet().size() == 0) {
							results.add(startIndex);
							window.putAll(windowCopy);
							remain.putAll(remainCopy);
							i = startIndex + 1;
							startIndex = i;
							continue;
						}
					} else {
						window.putAll(windowCopy);
						remain.putAll(remainCopy);
						i = startIndex + 1;
						startIndex = i;
						continue;
					}
				}
				i += count;
			} else {
				i = startIndex + 1;
				startIndex = i;
				window.putAll(windowCopy);
				remain.putAll(remainCopy);
			}
		}
		return results;
  }

  private String getS(char[] sArray, int startIndex, int count) {
    char[] temp = new char[count];
    for (int j = 0; j < count; j++) {
      temp[j] = sArray[startIndex + j];
    }
    return String.valueOf(temp);
  }
}
