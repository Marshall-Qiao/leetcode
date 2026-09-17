class Solution {
    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null || haystack.length() < needle.length()) return -1;
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                if (needle.length() == 1) return i;
                boolean isSame = true;
                for (int n = 1; n < needle.length(); n++) {
                    if (haystack.charAt(i + n) != needle.charAt(n)) {
                        isSame = false;
                        break;
                    }
                }
                if (isSame) return i;
            }
        }
        return -1;
    }
}