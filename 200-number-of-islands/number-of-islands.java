class Solution {
    public int numIslands(char[][] grid) {
        int result = 0;
        for (int n = 0; n < grid.length; n++) {
            for (int m = 0; m < grid[0].length; m++) {
                if (grid[n][m] == '1') {
                    result++;
                    dfs(grid, n, m);
                }
            }
        }
        return result;
    }
    public void dfs(char[][] grid, int n, int m) {
        if (n < 0 || m < 0 || n >= grid.length || m >= grid[0].length || grid[n][m] == '0') return;
        grid[n][m] = '0';
        dfs(grid, n + 1, m);
        dfs(grid, n - 1, m);
        dfs(grid, n, m + 1);
        dfs(grid, n, m - 1);
    }
}