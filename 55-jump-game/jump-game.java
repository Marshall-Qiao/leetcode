class Solution {
    public boolean canJump(int[] nums) {
        int goal = nums.length - 1;
        for(int i = nums.length - 2 ; i >= 0; i--){
            if(i+nums[i] >= goal)goal = i;
        }
        return goal == 0;
    }
    // public boolean canJump(int[] nums) {
    //    if(nums == null || nums.length == 0) return true;
    //    boolean[] visited = new boolean[nums.length];
    //    visited[0] = true; 
    //    for(int i = 0; i< nums.length;i++){
    //       if(!visited[i]) return false;
    //       if(i+nums[i] >= nums.length-1) return true;
    //       for(int j=i+1;j<= i+nums[i];j++){
    //          visited[j] = true;
    //       }
    //    }
    //    return true;
    // }
}