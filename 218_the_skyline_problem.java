class Solution {
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> result = new LinkedList<>();
        int m = buildings.length;
        if (m == 0) {
            return result;
        }
        Map<Integer, Integer> heightMap = new HashMap<>();
        PriorityQueue<Integer> ground = new PriorityQueue<>();
        for (int i = 0; i < m; i++) {
            int left = buildings[i][0];
            int right = buildings[i][1];
            int h = buildings[i][2];

            for (int j = left; j <= right; j++) {
                    if (!ground.contains(j)) {
                        ground.add(j);
                        heightMap.put(j, h);
                    } else {
                        int prev = heightMap.get(j);
                        if (prev < h) {
                            heightMap.put(j, h);
                        }
                    }
            }
        }

        int prev = 0;
        while (!ground.isEmpty()) {
            int location = ground.poll();
            int height = heightMap.getOrDefault(location, 0);
            if (height != prev) {
                int[] newLocation = {location, height};
                result.add(newLocation);
                prev = height;
            } else {
              if (!ground.contains(location + 1)) {
                  int[] newLocation = {location, 0};
                  result.add(newLocation);
                  prev = 0;
              } else {
                  int postHeight = heightMap.get(location + 1);
                  if (postHeight < height) {
                      int[] newLocation = {location, postHeight};
                      result.add(newLocation);
                      prev = postHeight;
                  }
              }
            }
        }
        return result;
    }
}
