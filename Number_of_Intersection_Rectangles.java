public class Solution {
        private boolean intersect(int[][] r1, int[][] r2) {
            return r1[0][0] < r2[0][0] && r1[0][1] < r2[0][1] && r2[0][0] < r1[1][0] && r2[0][1] < r1[1][1] ||
                    r1[0][0] < r2[1][0] && r1[0][1] < r2[1][1] && r2[1][0] < r1[1][0] && r2[1][1] < r1[1][1];
        }

        private int find(int val, int[] parents) {
            while (parents[val] != -1) {
                val = parents[val];
            }
            return val;
        }

        public int countIntersection(int[][][] rectangles) {
            if (rectangles == null || rectangles.length == 0) return 0;
            int n = rectangles.length;
            int[] parents = new int[n];
            Arrays.fill(parents, -1);
            for (int i = 0; i < n - 1; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (intersect(rectangles[i], rectangles[j])) {
                        int root1 = find(i, parents);
                        int root2 = find(j, parents);

                        if (root1 != root2) {
                            parents[root1] = root2;
                        }
                    }
                }
            }

            int count;
            for (int i = 0; i < n; i++) {
                if (parents[i] == -1) {
                  count++;
                }
            }

            return count;
        }
    }
