class Solution {
    public int orangesRotting(int[][] grid) {
        
        Queue<int[]> q = new LinkedList<>();

        int freshCount = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    freshCount++;
                } else if (grid[i][j] == 2){
                    q.offer(new int[]{i,j});
                }
            }
        }

        if (freshCount == 0) return 0;

        int minutes = 0;
        int[][] pairs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while (!q.isEmpty()) {
            int size = q.size();
            boolean hasEffect = false;
            for (int i = 0; i < size; i++) {
                int[] curr = q.poll();
                int x = curr[0], y = curr[1];
                 for (int[] p : pairs) {
                    int xn = x + p[0], yn = y + p[1];
                    if (xn >= 0 && yn >=0 && xn < grid.length && yn < grid[0].length 
                        && grid[xn][yn] == 1) {
                        grid[xn][yn] = 2;
                        q.offer(new int[]{xn, yn});
                        hasEffect = true;
                        freshCount--;
                    }
                 }
            }
            if(hasEffect) minutes++;
        }

        return freshCount == 0 ? minutes : -1;
    }
}