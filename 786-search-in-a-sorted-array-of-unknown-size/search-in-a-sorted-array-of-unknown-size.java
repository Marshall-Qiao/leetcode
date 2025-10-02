/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */

class Solution {
    public int search(ArrayReader reader, int target) {
       if (reader.get(0) == Integer.MAX_VALUE) return -1;
       
       int l = 0, r = Integer.MAX_VALUE;
       while (l <= r) {
          int mid = l + (r - l) / 2;
          if (reader.get(mid) == Integer.MAX_VALUE) {
            r = mid - 1;
            continue;
          }
          if (reader.get(mid) == target) return mid;
          if (reader.get(mid) > target) {
             r = mid - 1;
          } else {
             l = mid + 1;
          }
       }
       return -1;
    }
}