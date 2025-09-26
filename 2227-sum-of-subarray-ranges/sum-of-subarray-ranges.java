class Solution {
    public long subArrayRanges(int[] nums) {
        long res = 0;
        Stack<Integer> stack = new Stack<>();
        // find the sum of all minimum 
        for(int i = 0;i <= nums.length;i++){
            while(!stack.isEmpty() && (i == nums.length || nums[stack.peek()] >= nums[i])){
                int mid = stack.peek();
                stack.pop();
                int left = stack.isEmpty()? -1:stack.peek();
                res -=(long) nums[mid]*(i-mid)*(mid-left);
            }
            stack.add(i);
        }
        stack.clear();
        for(int i = 0;i <= nums.length;i++){
             while(!stack.isEmpty() && (i == nums.length || nums[stack.peek()] <= nums[i])){
                int mid = stack.peek();
                stack.pop();
                int left = stack.isEmpty()? -1:stack.peek();
                res +=(long) nums[mid]*(i-mid)*(mid-left);
            }
            stack.add(i);
        }
        return res;
    }
    // public long subArrayRanges(int[] nums) {
    //     long count = 0;
    //     for(int i = 0; i< nums.length;i++){
    //         int min = nums[i], max = nums[i];
    //         for(int j = i; j< nums.length;j++){
    //             min=Math.min(min,nums[j]);
    //             max=Math.max(max,nums[j]);
    //             count+= max-min;
    //         }
    //     }
    //     return count;
    // }
}