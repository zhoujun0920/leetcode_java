class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((x, y) -> y - x);
        int i = 0;
        while (queue.size() < n) {
            if (i < primes.length) {
              int j = 0;
              int temp = queue.peek();
              
            }
        }
    }
}
