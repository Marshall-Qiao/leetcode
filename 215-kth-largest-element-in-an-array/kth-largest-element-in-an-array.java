class Solution {

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num : nums) {
            if (minHeap.size() < k) {
                minHeap.add(num);
            } else if (minHeap.peek() < num) {
                minHeap.poll();
                minHeap.add(num);
            }
        }
        return minHeap.peek();
    }

    // public int findKthLargest(int[] nums, int k) {
    //     int l = 0, r = nums.length-1, target = nums.length - k;
    //     while(true){
    //         int index = selectPart(nums,l,r);
    //         if(index == target) return nums[target];
    //         if(index > target){
    //             r = index - 1;
    //         }else{
    //             l = index + 1;
    //         }
    //     }
    // }

    // public int selectPart(int[] nums, int l, int r) {
    //     int random = ThreadLocalRandom.current().nextInt(l,r+1);
    //     swap(nums,random,r);
    //     int right = nums[r];
    //     int change = l;
    //     for(int j = l; j<r;j++){
    //         if(nums[j] <= right){
    //             swap(nums,j,change);
    //             change++;
    //         }
    //     }
    //     swap(nums,r,change);
    //     return change;
    // }

    // public void swap(int[] nums, int a, int b){
    //     int temp = nums[a];
    //     nums[a] = nums[b];
    //     nums[b] = temp;
    // }

    // public int findKthLargest(int[] nums, int k) {
    //     PriorityQueue<Integer> q = new PriorityQueue<Integer>();
    //     for(int i = 0;i<nums.length;i++){
    //         int now = nums[i];
    //         if(q.size() < k){
    //             q.add(now);
    //         }else if(q.peek() < now){
    //             q.poll();
    //             q.add(now);
    //         }
    //     }
    //     return q.peek();
    // }
}