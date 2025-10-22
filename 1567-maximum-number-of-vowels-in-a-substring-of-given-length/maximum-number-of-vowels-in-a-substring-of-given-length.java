class Solution {
    public int maxVowels(String s, int k) {
        s = s.toLowerCase();
        int count = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            boolean isVowel = isVowel(s.charAt(i));
            count += isVowel ? 1 : 0;
            if (i >= k) {
                boolean isVowelBefore = isVowel(s.charAt(i - k));
                count -= isVowelBefore ? 1 : 0;
            }
            max = Math.max(max, count); 
        }
        return max;
    }

    private static Set<Character> vowelSet;
    static {
        vowelSet = new HashSet<>();
        vowelSet.add('a');
        vowelSet.add('e');
        vowelSet.add('i');
        vowelSet.add('o');
        vowelSet.add('u');
    } 
    public boolean isVowel(char x) {
        return vowelSet.contains(x);
    }
}