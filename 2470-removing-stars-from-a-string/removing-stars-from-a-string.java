class Solution {
    public String removeStars(String s) {
       int startNum = 0;
       String res = "";
       for (int i = s.length() - 1; i >= 0; i--){
          if (s.charAt(i) == '*'){
            startNum++;
            continue;
          }
          if (startNum > 0){
            startNum--;
            continue;
          }
          res = s.charAt(i) + res;
       } 
       return res;
    }
}