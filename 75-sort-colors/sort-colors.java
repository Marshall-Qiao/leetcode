class Solution {
    public void sortColors(int[] nums) {
      int red = 0, white = 0, blue = 0;
      for (int i = 0; i < nums.length; i++) {
        red += nums[i] == 0 ? 1 : 0;
        white += nums[i] == 1 ? 1 : 0;
        blue += nums[i] == 2 ? 1 : 0;
      }  
      for (int i = 0; i < red; i++) {
        nums[i] = 0;
      }
      for (int i = 0; i < white; i++) {
        nums[red + i] = 1;
      }
      for (int i = 0; i < blue; i++) {
        nums[red + white + i] = 2;
      }
    }
}