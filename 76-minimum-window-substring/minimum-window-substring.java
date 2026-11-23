class Solution {
    public String minWindow(String s, String t) {
        if (t.isEmpty() || t.length() > s.length()) return "";

        Map<Character, Integer> tCharInt = new HashMap<>();
        for (char c : t.toCharArray()){
            tCharInt.merge(c, 1, Integer::sum);
        }
        
        int missing = t.length();
        int l = 0;
        int bestStart = 0;
        int bestLen = s.length() + 1;
        Map<Character, Integer> counts = new HashMap<>();
        for (int r = 0; r < s.length(); r++) {
            char added = s.charAt(r);
            int count = counts.merge(added, 1, Integer::sum);
            if(count <= tCharInt.getOrDefault(added, 0)) {
                missing--;
            }
            while (missing == 0) {
                int len = r - l + 1;
                if (len < bestLen){
                   bestLen = len;
                   bestStart = l; 
                }

                char removed = s.charAt(l++);
                int remaining = counts.merge(removed, -1, Integer::sum);
                if(remaining < tCharInt.getOrDefault(removed, 0)) {
                    missing++;
                }
            }
        }
        return bestLen == s.length() + 1 ? "" : s.substring(bestStart, bestStart + bestLen);
    }
}