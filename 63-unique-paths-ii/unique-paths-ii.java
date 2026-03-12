class Solution {
    // public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    //     if (obstacleGrid.length == 0 || obstacleGrid[0][0] == 1) return 0;
        
    //     int[][] dp = new int[obstacleGrid.length + 1][obstacleGrid[0].length + 1];
    //     dp[0][1] = 1;
    //     for (int i = 1; i < obstacleGrid.length + 1; i++) {
    //         for (int j = 1; j < obstacleGrid[0].length + 1; j++) {
    //             if (obstacleGrid[i - 1][j - 1] == 1){
    //                 dp[i][j] = 0;
    //                 continue;
    //             }
    //             dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
    //         }
    //     }
    //     return dp[obstacleGrid.length][obstacleGrid[0].length];
    // }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        int[] dp = new int[m];
        dp[0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (obstacleGrid[i][j] == 1){
                    dp[j] = 0;
                } else if (j > 0){
                    dp[j] += dp[j - 1];
                }
            }
        }
        return dp[m - 1];
    }
}