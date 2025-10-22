class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> set1 = Arrays.stream(nums1)
                                     .boxed() // Convert int to Integer objects
                                     .collect(Collectors.toCollection(HashSet::new));
        Set<Integer> set2 = Arrays.stream(nums2)
                                     .boxed() // Convert int to Integer objects
                                     .collect(Collectors.toCollection(HashSet::new));
        List<List<Integer>> res = new ArrayList<>();
        Set<Integer> list1 = new HashSet<>(); 
        Set<Integer> list2 = new HashSet<>(); 
        for (int one : nums1) {
            if (!set2.contains(one)) list1.add(one);
        }
         for (int one : nums2) {
            if (!set1.contains(one)) list2.add(one);
        }
        res.add(new ArrayList<>(list1));
        res.add(new ArrayList<>(list2));
        return res;
    }
}