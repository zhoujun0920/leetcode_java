class LRUCache {

    int capacity;
    Node head;
    Node tail;

    Map<Integer, Node> map;

    private class Node {
        int key;
        int value;
        Node previous;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.previous = null;
            this.next = null;
        }
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.previous = head;
        map = new HashMap<>();
    }

    public int get(int key) {
       if (map.containsKey(key)) {
           Node temp = map.get(key);
           Node previous = temp.previous;
           Node next = temp.next;
           previous.next = next;
           next.previous = previous;
           temp.next = head.next;
           temp.next.previous = temp;
           temp.previous = head;
           head.next = temp;
           return temp.value;
       }
        return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node temp = map.get(key);
            temp.value = value;
            get(key);
        } else {
            Node temp = new Node(key, value);
            temp.next = head.next;
            temp.previous = head;
            head.next = temp;
            temp.next.previous = temp;
            map.put(key, temp);
            if (map.size() > this.capacity) {
                int removeKey = tail.previous.key;
                Node previous = tail.previous.previous;
                previous.next = tail;
                tail.previous= previous;
                map.remove(removeKey);
            }

        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
