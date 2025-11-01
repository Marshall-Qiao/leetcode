class Solution {

    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);
        
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[nums.length - 1];
    }
    // public int rob(int[] nums) {
    //     // dp[n] = max(dp[n-1], dp[n-2]+a[n])
    //     // dp[0] = a[0];
    //     // dp[1] = max(a[0],a[1]);
    //     if(nums.length == 0) return 0;
    //     Map<Integer,Integer> memo = new HashMap<Integer,Integer>();  
    //     return dp(nums,nums.length -1,memo);
    // }
    // public int dp(int[] nums, int n,Map<Integer,Integer> memo){
    //     if(n == 0) return nums[0];
    //     if(n == 1) return Math.max(nums[0],nums[1]);
    //     if(memo.get(n) != null) return (int)memo.get(n);
    //     int res =  Math.max(dp(nums,n-1,memo), dp(nums,n-2,memo)+nums[n]);
    //     memo.put(n,res);
    //     return res;
    // }
}