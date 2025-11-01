class Solution {
    public int numTilings(int n) {
        if (n <= 2) return n;
        long MOD = 1000000007;
        long[] dp = new long[n + 1];
        dp[0] = 1; dp[1] = 1; dp[2] = 2;
        // dp[n]=2⋅dp[n−1]+dp[n−3]
        for (int i = 3; i <= n; i++) {
            dp[i] = (2 * dp[i - 1]+ dp[i - 3]) % MOD ;
        }
        return (int)dp[n];
    }
}