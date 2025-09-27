class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length <= 1) return nums.length;
        Arrays.sort(nums);
        int count = 1;
        int max = 0;
        for(int i = 1; i<= nums.length;i++){
            if(i < nums.length && nums[i-1] == nums[i]){
              continue;   
            }
            if(i< nums.length && nums[i-1]+1 == nums[i]){
                count++;
            }else{
                max = Math.max(count,max);
                count = 1;
            }
        }
        return max;
    }
}