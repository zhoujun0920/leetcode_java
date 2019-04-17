class MyQueue {

    Stack<Integer> queue;
    Stack<Integer> backwardQueue;

    /** Initialize your data structure here. */
    public MyQueue() {
        queue = new Stack<>();
        backwardQueue = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        if (empty()) {
            queue.push(x);
        } else {
            if (queue.isEmpty()) {
                while (!backwardQueue.isEmpty()) {
                    int temp = backwardQueue.pop();
                    queue.push(temp);
                }
            }
            queue.push(x);
        }
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (queue.isEmpty()) {
            return backwardQueue.pop();
        }
        while (!queue.isEmpty()) {
            int temp = queue.pop();
            backwardQueue.push(temp);
        }
        return backwardQueue.pop();
    }

    /** Get the front element. */
    public int peek() {
        if (queue.isEmpty()) {
            return backwardQueue.peek();
        }
        while (!queue.isEmpty()) {
            int temp = queue.pop();
            backwardQueue.push(temp);
        }
        return backwardQueue.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return queue.isEmpty() && backwardQueue.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
