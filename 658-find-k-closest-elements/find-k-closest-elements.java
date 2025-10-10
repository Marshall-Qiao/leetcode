class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int l = 0, r = arr.length - k;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (x - arr[mid] > arr[mid + k] - x){
                l = mid + 1; 
            } else {
                r = mid;
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int i = l; i < k+l; i++) {
            list.add(arr[i]);
        }
        return list;
    }
}