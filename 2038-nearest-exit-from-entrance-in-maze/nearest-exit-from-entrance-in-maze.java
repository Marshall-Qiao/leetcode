class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int n = maze.length; 
        int m = maze[0].length;
        boolean[][] visited = new boolean[n][m]; 
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{entrance[0], entrance[1], 0});
        visited[entrance[0]][entrance[1]] = true;
        int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int x = curr[0], y = curr[1], step = curr[2];
            if ( !(x == entrance[0] && y == entrance[1]) 
                && (x == 0 || y == 0 || x == n - 1 || y == m - 1)) {
                    return step;
            }
            for (int[] d : dirs) {
                int xn = x + d[0], yn = y + d[1];
                if (xn >= 0 && xn < n && yn >= 0 && yn < m 
                    && maze[xn][yn] == '.' && !visited[xn][yn] ) {
                    visited[xn][yn] = true;
                    q.offer(new int[]{xn, yn, step + 1});
                }
            }
        }
        return -1;
    }
    // int res = -1;
    // public int nearestExit(char[][] maze, int[] entrance) {
    //     int[][] dp = new int[maze.length][maze[0].length];
    //     for (int i = 0; i < maze.length; i++) {
    //         for (int j = 0; j < maze[0].length; j++) {
    //             dp[i][j] = maze[i][j] == '+' ? -1 : Integer.MAX_VALUE;
    //         }
    //     }
    //     dp[entrance[0]][entrance[1]] = 0;
        
    //     boolean[][] visited = new boolean[maze.length][maze[0].length];
    //     bfs(dp, visited, entrance, -1);
    //     return res;
    // }

    // public void bfs (int[][] dp, boolean[][] visited, int[] entrance, int lastStep) {
    //     if (visited[entrance[0]][entrance[1]] == true) return;
    //     visited[entrance[0]][entrance[1]] = true;
    //     if (dp[entrance[0]][entrance[1]] == -1) return;

    //     dp[entrance[0]][entrance[1]] = Math.min(dp[entrance[0]][entrance[1]], lastStep + 1); 
    //     if (lastStep != -1 && (entrance[0] == 0 || entrance[1] == 0 || entrance[0] == visited.length - 1 || entrance[1] == visited[0].length - 1 )) {
    //         if (res == -1) {
    //             res = dp[entrance[0]][entrance[1]];
    //         } else {
    //             res = Math.min(dp[entrance[0]][entrance[1]], res);
    //         }
    //     }      


    //     int l_up = entrance[0] - 1;
    //     int l_down = entrance[0] + 1;
    //     int r_up = entrance[1] - 1;
    //     int r_down = entrance[1] + 1;
        
    //     int row = visited.length - 1;
    //     int col = visited[0].length - 1;
        
    //     if(l_up >= 0) {
    //         bfs(dp, visited, new int[]{l_up, entrance[1]}, dp[entrance[0]][entrance[1]]);
    //     }
    //     if(l_down <= row) {
    //         bfs(dp, visited, new int[]{l_down, entrance[1]}, dp[entrance[0]][entrance[1]]);
    //     }
    //     if(r_up >= 0) {
    //         bfs(dp, visited, new int[]{entrance[0], r_up}, dp[entrance[0]][entrance[1]]);
    //     }
    //     if(r_down <= col) {
    //         bfs(dp, visited, new int[]{entrance[0], r_down}, dp[entrance[0]][entrance[1]]);
    //     }
    // }
}