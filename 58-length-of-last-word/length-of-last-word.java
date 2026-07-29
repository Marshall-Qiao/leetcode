class Solution {
    public int lengthOfLastWord(String s) {
        if (s == null) return 0;
        s = s.trim();
        String[] array = s.split(" ");
        return array[array.length - 1].length();
    }
}