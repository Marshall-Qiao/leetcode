class Solution {
    public void moveZeroes(int[] nums) {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                q.offer(i);
                continue;
            }
            if (!q.isEmpty()) {
                int zero = q.poll().intValue();
                int temp = nums[zero];
                nums[zero] = nums[i];
                nums[i] = temp;
                q.offer(i);
            }
        }
    }
}