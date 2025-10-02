class Solution {
    public int myAtoi(String s) {
        long res = 0; 
        boolean isStart = false;
        boolean isNegative = false;
        for ( int i = 0; i < s.length() ; i++ ) {
            char a = s.charAt(i);
            if ( !isStart ) {
                if ( a == ' ' ) continue;
                if ( a == '+' ) {
                    isStart = true;
                    continue;
                }
                if ( a == '-') {
                   isNegative = true;
                   isStart = true;
                   continue; 
                }
                if ( Character.isDigit( a ) ) {
                   res = a - '0';
                   isStart = true;
                   continue; 
                }
                break;
             }
            if ( !Character.isDigit( a ) ) break;
            
            res = 10 * res + (a - '0');
            if ( res > Integer.MAX_VALUE ) break;
        }
        if ( isNegative && res > Integer.MAX_VALUE ) return Integer.MIN_VALUE;
        if ( res > Integer.MAX_VALUE ) return Integer.MAX_VALUE;
        return isNegative ? ( int ) -res : ( int ) res;
    }
}