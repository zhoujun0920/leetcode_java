class Solution {
        List<String> result;
        boolean found = false;
    public List<String> findItinerary(String[][] tickets) {
        result = new LinkedList<>();
        int m = tickets.length;
        if (m == 0) {
            return result;
        }
        Map<String, List<String>> hm = new HashMap<>();
        for (int i = 0; i < tickets.length; i++) {
            String[] ticket = tickets[i];
            List<String> s = hm.getOrDefault(ticket[0], new LinkedList<>());
            s.add(ticket[1]);
            hm.put(ticket[0], s);
        }
        result.add("JFK");
        recursive(hm, "JFK");
        return result;
    }

    private void recursive(Map<String, List<String>> hm, String previous) {
        if (!found) {
            if (hm.isEmpty()) {
                found = true;
                return;
            }
            if (!hm.containsKey(previous)) {
                return;
            }
            List<String> tickets = hm.get(previous);
            tickets.sort((x, y) -> x.compareTo(y));
            for (int i = 0; i < tickets.size(); i++) {
                String temp = tickets.get(i);
                tickets.remove(i);
                if (tickets.size() > 0) {
                    hm.put(previous, tickets);
                } else {
                    hm.remove(previous);
                }
                result.add(temp);
                recursive(hm, temp);
                if (found) {
                    break;
                }
                result.remove(result.size() - 1);
                tickets.add(i, temp);
                hm.put(previous, tickets);
            }
        }
    }
}
