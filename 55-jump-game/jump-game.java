class Solution {
    public boolean canJump(int[] nums) {
        boolean[] dp = new boolean[nums.length];
        dp[0] = true;
        for (int i = 0; i < nums.length - 1; i++) {
            if (!dp[i]){
                return false;
            }
            if (i + nums[i] >= nums.length - 1) return true;
            for (int m = 0; m < nums[i]; m++){
                dp[i + m + 1] = true;
            }
        }
        return dp[nums.length - 1];
    }
}