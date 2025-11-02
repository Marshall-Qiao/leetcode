class Solution {

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j ++) {
                if (i == 0 && j == 0) continue;
                if (i == 0) {
                    dp[0][j] = dp[0][j - 1];
                    continue;
                }
                if (j == 0) {
                    dp[i][0] = dp[i - 1][0];
                    continue;
                }
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
    // public int uniquePaths(int m, int n) {
    //     // [l = 0, r = 0] --> [m-1][n-1]
    //     // we do loop l -->big or r big  --> l =[m-1] and r =[n-1] result add 1
    //     // dp[l][r] = dp[l-1][r] or dp[l][r-1]
    //     Map<String,Integer> memo = new HashMap<String,Integer>();
    //     return dp(m-1,n-1,memo);
    // }
    // public int dp(int l, int r,Map<String,Integer> memo){
    //     if(l < 0 && r < 0) return 0;
    //     // only one way to left or right
    //     if(l == 0 || r == 0) return 1;
    //     if(memo.get(l+"_"+r) != null ) return memo.get(l+"_"+r);
    //     int res = dp(l-1,r,memo)+dp(l,r-1,memo);
    //     memo.put(l+"_"+r,res);
    //     return res;
    // }
}