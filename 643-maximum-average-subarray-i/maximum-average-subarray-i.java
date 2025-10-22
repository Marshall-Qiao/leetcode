class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        double max = 0.00;
        for (int i = 0; i < nums.length; i++){
            sum += nums[i];
            if (i < k){
                max = (double) sum / (i + 1);
                continue;
            } 
            sum -= nums[i - k];
            max = Math.max((double) sum / k, max);
        }
        return max;
    }
}