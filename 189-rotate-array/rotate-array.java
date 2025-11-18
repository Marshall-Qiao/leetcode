class Solution {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        int[] temp = new int[k];
        for (int i = 0; i < k; i++) {
            temp[i] = nums[nums.length - k + i];
        }
        for (int i = nums.length - 1; i >= k; i--) {
            nums[i] = nums[i - k];
        }
        for (int i = 0; i < k; i++) {
            nums[i] = temp[i];
        }
    }
    // public void rotate(int[] nums, int k) {
    //     int size = nums.length;
    //     if(size <= k) k = k % size;

    //     int[] temp = new int[k];
    //     for(int i = 0; i< k ;i++){
    //         temp[i] = nums[size-k+i];
    //     }

    //     for(int j = size -1 ; j>= k;j--){
    //         nums[j] = nums[j-k];
    //     }

    //      for(int i = 0; i< k ;i++){
    //         nums[i] = temp[i];
    //     }

    // }
}