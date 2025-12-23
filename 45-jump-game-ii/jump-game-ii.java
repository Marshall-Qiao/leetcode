class Solution {
    public int jump(int[] nums) {
      int n = nums.length;
      int[] dp = new int[n];
      Arrays.fill(dp, Integer.MAX_VALUE);
      dp[0] = 0;
      for (int i = 0; i < n; i++) {
         int max = Math.min(n - 1, i + nums[i]);
         for (int m = i + 1; m <= max; m++) {
            dp[m] = Math.min(dp[m], dp[i] + 1);
         }
      }  
      return dp[n - 1];
    }
}