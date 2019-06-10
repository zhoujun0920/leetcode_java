class Solution {
    public String[] reorderLogFiles(String[] logs) {
        PriorityQueue<String> pq = new PriorityQueue<String>( (s1, s2) -> {
            String[] temp1 = s1.split(" ", 2);
            String[] temp2 = s2.split(" ", 2);
            if (temp1[1].equals(temp2[1])) {
                return s2.compareTo(s1);
            } else {
                return temp2[1].compareTo(temp1[1]);
            }
        });
        String[] results = new String[logs.length];
        int index = logs.length - 1;
        for(int i = logs.length - 1; i >=0; i--) {
            String[] temp = logs[i].split(" ", 3);
            if (temp[1].charAt(0) >= '0' && temp[1].charAt(0) <= '9') {
                results[index--] = logs[i];
            } else {
                pq.offer(logs[i]);
            }
        }
        while(!pq.isEmpty()) {
            results[index] = pq.poll();
            index--;
        }
        return results;
    }
}
