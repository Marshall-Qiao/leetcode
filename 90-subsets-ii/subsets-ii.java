class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        backTrack(nums, 0, new LinkedList<Integer>(), result);
        return result;
    }
    public void backTrack(int[] nums, int index, List<Integer> list ,List<List<Integer>> result) {
        result.add(new ArrayList<>(list));
        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i - 1]) continue;
            list.add(nums[i]);
            backTrack(nums, i + 1, list, result);
            list.removeLast();
        }
    }
}