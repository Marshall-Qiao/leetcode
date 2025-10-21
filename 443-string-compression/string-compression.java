class Solution {
    public int compress(char[] chars) {
        
        int idx = 0;
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            int count = 1;
            while (i + 1 < chars.length && chars[i + 1] == c) {
                i++;
                count++;
            }
            chars[idx] = c;
            idx++;
            if (count != 1){
                for (char digit : (count+"").toCharArray()){
                    chars[idx] = digit;
                    idx++;
                }
            }
        }
        return idx;
    }
}