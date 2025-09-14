class Solution {
    public int romanToInt(String s) {
        int count = 0;
        for(int i = 0 ; i< s.length() ; i++){
            int a = getIntFromChar(s.charAt(i));
            int b = i+1<s.length() ? getIntFromChar(s.charAt(i+1)): 0;
           if(b > a){
                i++;
                count = count+b-a;
            }else{
                count +=a; 
            }
        }
        return count;
    }
    public int getIntFromChar(char x){
        if(x == 'I') return 1;
        if(x == 'V') return 5;
        if(x == 'X') return 10;
        if(x == 'L') return 50;
        if(x == 'C') return 100;
        if(x == 'D') return 500;
        if(x == 'M') return 1000;
        return -1;
    }
 
}