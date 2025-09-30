class Solution {
    public String convert(String s, int numRows) {
        // 00        03      06
        //       12  13   15 16
        //     21    23
        //           43  
        
        // for(int i = 0; i < numRows;i++){

            //  i(numRows-1)*0       i[(numRows-1) *1]      i[(numRows-1)*2]
                //   (numRows-1) *1 < [j] == (numRows-1) *1 - i < (numRows-1)
            // (
                // j%(numRows-1) == 0  + i
                // j%(numRows-1) != 0  numRows + numRows-i
        //    int col = 0;
        //    while(true){
        //       int j = (numRows-1) * col;
        //       if(i !=0 && i != numRows -1){
        //          int j1 = (numRows-1) *col - i;
        //          if(j1>(numRows-1)*(col-1) && j1<j){
        //             int n = (j+1)/numRows * (numRows+numRows-2) + numRows + numRows-i;
        //             if(n>=s.length()) break;
        //             list.add(s.charAt(n));
        //          }
        //       }
        //        int m = (j+1)/numRows * (numRows+numRows-2) + i;
        //        if( m >=s.length()) break;
        //        list.add(s.charAt(m));
        //        col++;
        //    }
        // }
        if (numRows == 1 || s.length() <= numRows) return s;


        List<String> list = new ArrayList<>();
        int cycle = 2 * numRows - 2 ;
        for(int i = 0;i<numRows;i++){
            for(int j = i; j < s.length();j += cycle){
                list.add(s.charAt(j)+"");
                int diag = j + cycle - 2*i;
                if(i != 0 && i != numRows - 1 && diag < s.length()){
                    list.add(s.charAt(diag)+"");
                }
            }
        }

        return String.join("", list);

    }
}