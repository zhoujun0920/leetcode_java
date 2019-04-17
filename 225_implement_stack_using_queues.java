 class MyStack {

        Queue<Integer> queue1;
        Queue<Integer> queue2;

        /** Initialize your data structure here. */
        public MyStack() {
            queue1 = new LinkedList<>();
            queue2 = new LinkedList<>();
        }

        /** Push element x onto stack. */
        public void push(int x) {
            if (queue1.isEmpty()) {
                queue2.offer(x);
            } else {
                queue1.offer(x);
            }
        }

        /** Removes the element on top of the stack and returns that element. */
        public int pop() {
            if (queue1.isEmpty()) {
                while (queue2.size() > 1) {
                    int temp = queue2.poll();
                    queue1.offer(temp);
                }
                return queue2.poll();
            } else {
                while (queue1.size() > 1) {
                    int temp = queue1.poll();
                    queue2.offer(temp);
                }
                return queue1.poll();
            }
        }

        /** Get the top element. */
        public int top() {
            if (queue1.isEmpty()) {
                while (queue2.size() > 1) {
                    int temp = queue2.poll();
                    queue1.offer(temp);
                }
                int result = queue2.poll();
                queue1.offer(result);
                return  result;
            } else {
                while (queue1.size() > 1) {
                    int temp = queue1.poll();
                    queue2.offer(temp);
                }
                int result = queue1.poll();
                queue2.offer(result);
                return result;
            }
        }

        /** Returns whether the stack is empty. */
        public boolean empty() {
            return queue1.isEmpty() && queue2.isEmpty();
        }
    }

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
