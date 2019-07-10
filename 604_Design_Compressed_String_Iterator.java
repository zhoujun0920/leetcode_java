class StringIterator {

    List<Character> list;
    List<Integer> count;
    int copyCount;
    int index;

    public StringIterator(String compressedString) {
        list = new LinkedList<>();
        count = new LinkedList<>();
        index = 0;
        int i = 0;
        while (i < compressedString.length()) {
            list.add(compressedString.charAt(i));
            StringBuilder sb = new StringBuilder();
            for (int j = i + 1; j < compressedString.length(); j++) {
                if (compressedString.charAt(j) >= '0' && compressedString.charAt(j) <= '9') {
                    sb.append(compressedString.charAt(j));
                    if (j == compressedString.length() - 1) {
                        i = j + 1;
                    }
                } else {
                    i = j;
                    break;
                }
            }
            int c = Integer.valueOf(sb.toString());
            count.add(c);
        }
    }

    public char next() {
        if (index >= list.size()) {
            return ' ';
        }
        char result = list.get(index);
        int c = count.get(index);
        count.set(index, c - 1);
        if (count.get(index) == 0) {
            index++;
        }
        return result;
    }

    public boolean hasNext() {
        return index < list.size();
    }
}

/**
 * Your StringIterator object will be instantiated and called as such:
 * StringIterator obj = new StringIterator(compressedString);
 * char param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
