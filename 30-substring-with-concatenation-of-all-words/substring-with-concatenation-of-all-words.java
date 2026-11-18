class Solution {

    public List<Integer> findSubstring(String s, String[] words) {
        
        Map<String,Integer> wordToCount = new HashMap<>();
        for(String word : words) {
            wordToCount.put(word, wordToCount.computeIfAbsent(word, k -> 0) + 1);
        }
        List<Integer> res = new LinkedList<>();

        int step = words[0].length();
        for(int i = 0; i < step; i++) {
            // Create an independent, modifiable copy
            Map<String, Integer> copy = new HashMap<>(wordToCount);
            int l = i, r = i;
            while ((r + step) <= s.length()){
                String currW = s.substring(r, r + step);
                r = r + step;
                if(!copy.containsKey(currW)){
                    copy = new HashMap<>(wordToCount);
                    l = r;
                    continue;
                }
                
                int currCount = copy.get(currW) - 1;
                copy.put(currW, currCount);
                while(copy.get(currW) < 0) {
                    String lWord = s.substring(l, l + step);
                    copy.put(lWord, copy.get(lWord) + 1);
                    l += step;
                }
                
                if ((r - l) / step == words.length) {
                    res.add(l);
                }
            }
        }

        return res;
    }
    // public List<Integer> findSubstring(String s, String[] words) {
        // HashMap<Integer,List<Integer>> allIndexToWord = new HashSet<>();
        // for(int i = 0; i < words.length; i++){
        //     int index = s.indexOf(words[i]);
        //     while (index >= 0) {
        //         System.out.println(index);
        //         index = s.indexOf(words[i], index + 1);
        //         allIndexToWord.computeIfAbsent(index, k -> new LinkedList<>()).add(i);
        //     }
        // }

        // List<Integer> allIdxStart = new ArrayList<>(allIndexToWord.keySet());
        // List<Integer> result = new ArrayList<>();

        // for(int i = 0; i < allIdxStart.length; i++){
        //     List<Integer> allHitsIdx = allIndexToWord.get(allIdxStart.get(i));
        //     Set<Integer> trackIndex = new HashSet<>();
            
        //     for(Integer hitIdx : allHitsIdx) {
        //         if(trackIndex.contains(hitIdx)) continue;
        //         trackIndex.add(hitIdx);

        //         int nexIdx = i + words[hitIdx].length;
        //         while(trackIndex.size() != words.size() && nexIdx < s.length() && allIdxStart.contains(nexIdx)){
        //            List<Integer> nextHitsIdx = allIdxStart.get(nexIdx);
        //            for (Integer nextHitIdx: nextHitsIdx) {
                     
        //            }
        //         }
        //         // 
        //         // hitIndex.add(hitIdx);
        //         // if(hitIndex.size() == words.size()){
        //         //     // only one and hit first indx
        //         //     result.add(hitIdx);
        //         //     hitIndex.remove(hitIdx);
        //         //     continue;
        //         // }
        //         // while()
        //     }
        // }

         
    // }



}