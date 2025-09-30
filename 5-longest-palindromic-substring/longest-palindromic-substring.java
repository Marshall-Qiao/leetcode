class Solution {
    public String longestPalindrome(String s) {
        int[] res = new int[2];
        res[0] = 0;
        res[1] = 0;
        for(int i = 0; i< s.length()-1; i++){
            for(int j = s.length()-1; j > i ; j--){
                int left = i, right = j ;
                while(left < right){
                    if(s.charAt(left) != s.charAt(right)){
                        break;
                    }
                    left++;
                    right--;
                }
                if(left>= right && res[1]-res[0] < j - i){
                   res[1] = j;
                   res[0] = i; 
                }
            }
        }

        return s.substring(res[0],res[1]+1);
    }
}