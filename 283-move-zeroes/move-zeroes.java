class Solution {
    public void moveZeroes(int[] nums) {
        int left = 0;
        for (int right = 0; right < nums.length; right++){
            if (nums[right] != 0) {
                int temp = nums[right];
                nums[right] = nums[left];
                nums[left] = temp;
                left++;
            }
        }
    }
    // public void moveZeroes(int[] nums) {
    //     Queue<Integer> q = new LinkedList<>();
    //     for (int i = 0; i < nums.length; i++) {
    //         if (nums[i] == 0) {
    //             q.offer(i);
    //             continue;
    //         }
    //         if (!q.isEmpty()) {
    //             int zero = q.poll().intValue();
    //             int temp = nums[zero];
    //             nums[zero] = nums[i];
    //             nums[i] = temp;
    //             q.offer(i);
    //         }
    //     }
    // }
}