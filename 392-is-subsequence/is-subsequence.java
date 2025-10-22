class Solution {
    public boolean isSubsequence(String s, String t) {
        if (s.length() > t.length()) return false;
        if (s.length() == 0) return true;
        int left = 0;
        int idx = 0;
        while (left < t.length()) {
            if (idx > s.length() - 1) return true;
            if (s.charAt(idx) == t.charAt(left)) {
                idx++;
            }
            left++;
        }
        return idx > s.length() - 1;
    }
}