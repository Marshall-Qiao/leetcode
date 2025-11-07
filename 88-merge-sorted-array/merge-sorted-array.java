class Solution {
    public ArrayList merge(int[] nums1, int m, int[] nums2, int n) {
        ArrayList<Integer> res = new ArrayList<>(m + n);
        int l = 0 , r = 0;
        while (l < m && r < n) {
             res.add(nums1[l] < nums2[r] ? nums1[l++] : nums2[r++]);
        }
        while (l < m) {
            res.add(nums1[l++]);
        }
        while (r < n) {
            res.add(nums2[r++]);
        }
        for (int i = 0; i < res.size(); i++) {
            nums1[i] = res.get(i);
        }
        return res;
    }
       
}