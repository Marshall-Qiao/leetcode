class NumArray {

    private int[] tree;
    private int n;

    public NumArray(int[] nums) {
        n = nums.length;
        if (n <= 0) return;
        tree = new int[4 * n];
        buildTree(nums, 0, 0, n - 1);
    }
    public void buildTree(int[] nums, int index, int start, int end) {
       if (start == end) {
         tree[index] = nums[start];
         return;
       }
       int mid = start + (end - start) / 2;
       buildTree(nums, 2 * index + 1, start, mid);
       buildTree(nums, 2 * index + 2, mid + 1, end);
       tree[index] = tree[2 * index + 1] + tree[2 * index + 2];
    }
    public void update(int index, int val) {
        updateTree(0, 0, n - 1, index, val);
    }
    

     public void updateTree(int treeIndex, int start, int end, int index, int val) {
       if (start == end) {
         tree[treeIndex] = val;
         return;
       }
       int mid = start + (end - start) / 2;
        // 注意 treeIndex <= mid
       if (index <= mid) {
            updateTree(2 * treeIndex + 1, start, mid, index, val);
       } else {
            updateTree(2 * treeIndex + 2, mid + 1, end, index, val);
       }
       tree[treeIndex] = tree[2 * treeIndex + 1] + tree[2 * treeIndex + 2];
    }

    public int sumRange(int left, int right) {
        return queryTree(0, 0, n-1, left, right);
    }

    public int queryTree(int treeIndex, int start, int end, int left, int right) {
        if (end < left || start > right) return 0;
        if (left <= start && end <= right) return tree[treeIndex];
        int mid = start + (end - start) / 2;
        // 注意 mid --> left  mid+1 --> left 
        int leftSum = queryTree( 2 * treeIndex + 1, start, mid, left, right);
        int rightSum = queryTree( 2 * treeIndex + 2, mid + 1, end, left, right);
        return leftSum + rightSum;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */