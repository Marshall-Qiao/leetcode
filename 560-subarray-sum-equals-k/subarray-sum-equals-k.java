class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0, 1);

        int sum = 0;
        int currentSum = 0;
        for (int i = 0; i < nums.length; i++) {
            currentSum += nums[i];
            sum += map.getOrDefault(currentSum - k, 0);
            map.put(currentSum, map.getOrDefault(currentSum, 0) + 1);
        }
        return sum;
    }
}