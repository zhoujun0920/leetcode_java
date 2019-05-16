class TwoSum {

    /** Initialize your data structure here. */

    Map<Integer, Integer> map;

    public TwoSum() {
        map = new HashMap<>();
    }

    /** Add the number to an internal data structure.. */
    public void add(int number) {
        Integer count = map.getOrDefault(number, 0);
        map.put(number, count + 1);
    }

    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int rest = value - entry.getKey();
            if (map.containsKey(rest)) {
                if (rest == entry.getKey()) {
                    if (entry.getValue() > 1) {
                        return true;
                    }
                    continue;
                }
                return true;
            }
        }
        return false;
    }
}
