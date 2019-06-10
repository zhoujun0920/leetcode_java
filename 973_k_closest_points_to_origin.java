class Solution {

    class Point {
        Integer x;
        Integer y;

        Point(Integer x, Integer y) {
            this.x = x;
            this.y = y;
        }

        public Integer distance() {
            return x * x + y * y;
        }
    }

    public int[][] kClosest(int[][] points, int K) {
        TreeMap<Integer, List<Point>> treeMap = new TreeMap<>();
        int count = 0;
        for (int[] point : points) {
            Point p = new Point(point[0], point[1]);
            Integer distance = p.distance();
            if (count >= K) {
                Integer last = treeMap.lastKey();
                if (last > distance) {
                    List<Point> temp = treeMap.get(last);
                    temp.remove(temp.size() - 1);
                    if (temp.size() == 0) {
                        treeMap.remove(last);
                    }
                    List<Point> newTemp = treeMap.getOrDefault(distance, new LinkedList<>());
                    newTemp.add(p);
                    treeMap.put(distance, newTemp);
                }
            } else {
                List<Point> newTemp = treeMap.getOrDefault(distance, new LinkedList<>());
                newTemp.add(p);
                treeMap.put(distance, newTemp);
                count++;
            }
        }

        int[][] result = new int[count][2];
        int i = 0;
        for(Map.Entry<Integer, List<Point>> entry : treeMap.entrySet()) {
            for (Point point : entry.getValue()) {
                result[i][0] = point.x;
                result[i][1] = point.y;
                i++;
            }
        }
        return result;
    }
}

class Solution {

    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>( (p1, p2) -> p2[0] * p2[0] + p2[1] * p2[1] - p1[0] * p1[0] - p1[1] * p1[1]);
        for (int[] point : points) {
          pq.offer(point);
          if (pq.size() > K) {
            pq.poll();
          }
        }
        int[][] result = new int[pq.size()][2];
        int i = pq.size() - 1;
        while (!pq.isEmpty()) {
          result[i] = pq.poll();
          i--;
        }
        return result;
    }
}


class Solution {

    public int[][] kClosest(int[][] points, int K) {
        quickSort(points, K, 0, points.length - 1);
        return Arrays.copyOfRange(points, 0, K);
    }

     private void quickSort(int[][] points, int K, int start, int end) {
        if (start < end) {
            int mid = partition(points, start, end);
            if (mid == K) {
                return;
            }
            if (mid < K) {
                quickSort(points, K,mid + 1, end);
            } else {
                quickSort(points, K, start, mid - 1);
            }
        }
    }

     private int partition(int[][] points, int start, int end) {
        int[] pivot = points[end];
        int i = start;
        for (int j = start; j < end; j++) {
            if (distance(points[j]) < distance(pivot)) {
                swap(points, i, j);
                i++;
            }
        }
        swap(points, i, end);
        return i;
    }

     private void swap(int[][] points, int i, int j) {
        int x = points[i][0];
        int y = points[i][1];
        points[i][0] = points[j][0];
        points[i][1] = points[j][1];
        points[j][0] = x;
        points[j][1] = y;
    }

     private int distance(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }
}

class Solution {
    int[][] points;
    public int[][] kClosest(int[][] points, int K) {
        this.points = points;
        sort(0, points.length - 1, K);
        return Arrays.copyOfRange(points, 0, K);
    }

    public void sort(int i, int j, int K) {
        if (i >= j) return;
        int k = ThreadLocalRandom.current().nextInt(i, j);
        swap(i, k);

        int mid = partition(i, j);
        int leftLength = mid - i + 1;
        if (K < leftLength)
            sort(i, mid - 1, K);
        else if (K > leftLength)
            sort(mid + 1, j, K - leftLength);
    }

    public int partition(int i, int j) {
        int oi = i;
        int pivot = dist(i);
        i++;

        while (true) {
            while (i < j && dist(i) < pivot)
                i++;
            while (i <= j && dist(j) > pivot)
                j--;
            if (i >= j) break;
            swap(i, j);
        }
        swap(oi, j);
        return j;
    }

    public int dist(int i) {
        return points[i][0] * points[i][0] + points[i][1] * points[i][1];
    }

    public void swap(int i, int j) {
        int t0 = points[i][0], t1 = points[i][1];
        points[i][0] = points[j][0];
        points[i][1] = points[j][1];
        points[j][0] = t0;
        points[j][1] = t1;
    }
}


class Solution {
    public int[][] kClosest(int[][] points, int K) {
        quickSort(points, 0, points.length - 1, K);
        return Arrays.copyOfRange(points, 0, K);
    }

    private void quickSort(int[][] points, int start, int end, int K) {
        if (start < end) {
            int partition = partition(points, start, end);
            if (partition > K) {
                quickSort(points, start, partition - 1, K);
                quickSort(points, partition + 1, end, K);
            } else if (partition < K) {
                quickSort(points, partition + 1, end, K);
            } else {
                return;
            }
        }
    }

    private int partition(int[][] points, int start, int end) {
        int pivot = points[end][0] * points[end][0] + points[end][1] * points[end][1];
        int j = start;
        for (int i = start + 1; i < end; i++) {
            int current = points[i][0] * points[i][0] + points[i][1] * points[i][1];
            if (current > pivot) {
                int x = points[i][0];
                int y = points[i][1];
                points[i][0] = points[j][0];
                points[i][1] = points[j][1];
                points[j][0] = x;
                points[j][1] = y;
                j++;
            }
        }
        int x = points[j][0];
        int y = points[j][1];
        points[j][0] = points[end][0];
        points[j][1] = points[end][1];
        points[end][0] = x;
        points[end][1] = y;
        return j;
    }
}
