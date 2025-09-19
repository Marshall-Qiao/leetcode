class Solution {
    public int strStr(String haystack, String needle) {
        int peer = 0; int min = Integer.MAX_VALUE;
        List<Integer> misList = new ArrayList<Integer>();

        for(int i = 0; i< haystack.length();i++){
            char hay = haystack.charAt(i);
            if(hay != needle.charAt(peer) && hay != needle.charAt(0)){
                peer = 0;
                continue;
            }
            if(hay != needle.charAt(peer)){
               peer = 0; 
            }

            peer++;
            if(peer == needle.length()){
                min = Math.min(min,i-peer+1);
                peer = 0;
                continue;
            }

            if(peer != 1 && haystack.charAt(i) == needle.charAt(0)){
                misList.add(i);
            }
        }

        for(int i = 0; i< misList.size();i++){
            Integer start = misList.get(i);
            boolean isMatch = true;
            for(int j = start; j< (start+needle.length());j++ ){
                if(j>=haystack.length() || haystack.charAt(j) != needle.charAt(j-start)){
                    isMatch = false;
                    break;
                }
            }
            if(isMatch) min = Math.min(min,start);
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}