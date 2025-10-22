class Solution {
    public int maxOperations(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int num : nums) {
            Integer count = map.getOrDefault(num, 0) + 1;
            map.put(num, count);
        }
        int sum = 0;
         for (int num : nums) {
            Integer count_1 = map.get(num);
            if (count_1 == null || count_1 == 0) continue;
            Integer count_2 = map.get(k - num);
            if (count_2 == null || count_2 == 0) continue;
            if (k == 2 * num && count_2 < 2) continue;
            map.put(num, map.get(num) - 1);
            map.put(k - num, map.get(k - num) - 1);
            sum++;
        }
        return sum;
    }
}