class Solution {
    private static Set<Character> set = new HashSet<>();
    static{
        set.add('a'); set.add('A');
        set.add('e'); set.add('E');
        set.add('i'); set.add('I');
        set.add('o'); set.add('O');
        set.add('u'); set.add('U');
    }

    public String reverseVowels(String s) {
        int len = s.length();
        if (s == null || len <= 1) return s;
        int l = 0, r = len - 1;
        while (l < r) {
            while (l < r) {
                if (set.contains(s.charAt(l))) {
                    break;
                } else {
                    l++;
                }
            }
            while (l < r) {
                if (set.contains(s.charAt(r))) {
                    break;
                } else {
                     r--;
                }
            }
            if (l < r) {
                String left = s.charAt(l) + "";
                String right = s.charAt(r) + "";
                String firstPart = s.substring(0, l);
                String midPart = s.substring(l + 1, r);
                String lastPart = (r == len - 1) ? "" : s.substring(r + 1);
                s = firstPart + right + midPart + left + lastPart;
                l++;
                r--;
            }
        }
        return s;
    }
}