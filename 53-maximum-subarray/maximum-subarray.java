class Solution {
    public int maxSubArray(int[] nums) {
       int count = 0,best = Integer.MIN_VALUE;
       for(int i = 0; i< nums.length;i++){
            count += nums[i];
            best = Math.max(best,count);
            if(count < 0){ 
                count = nums[i] < 0 ? 0 : nums[i];
                continue;
            } 
       }
       return best;
        
    }
}