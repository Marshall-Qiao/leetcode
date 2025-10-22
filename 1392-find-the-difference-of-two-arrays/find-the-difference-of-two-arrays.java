class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> set1 = Arrays.stream(nums1)
                                     .boxed() // Convert int to Integer objects
                                     .collect(Collectors.toCollection(HashSet::new));

        Set<Integer> set2 = Arrays.stream(nums2)
                                     .boxed() // Convert int to Integer objects
                                     .collect(Collectors.toCollection(HashSet::new));
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>(); res.add(list1);
        List<Integer> list2 = new ArrayList<>(); res.add(list2);
        for (int one : set1) {
            if (!set2.contains(one)) list1.add(one);
        }
         for (int one : set2) {
            if (!set1.contains(one)) list2.add(one);
        }
        return res;
    }
}