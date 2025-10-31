class Solution {
    final static Map<Integer, List<Character>> map;
    static {
        map = new HashMap<>();
        map.put(2, Arrays.asList('a','b','c'));
        map.put(3, Arrays.asList('d','e','f'));
        map.put(4, Arrays.asList('g','h','i'));
        map.put(5, Arrays.asList('j','k','l'));
        map.put(6, Arrays.asList('m','n','o'));
        map.put(7, Arrays.asList('p','q','r','s'));
        map.put(8, Arrays.asList('t','u','v'));
        map.put(9, Arrays.asList('w','x','y','z'));

    }
    public List<String> letterCombinations(String digits) {
        List<List<Character>> list = new ArrayList<>();
        for (char c : digits.toCharArray()) {
            if (map.get((c - '0')) == null) continue;
            list.add(map.get((c - '0')));
        }
        List<String> res = getAllLetterComb(list, null, 0);
        return res;
    }

    public List<String> getAllLetterComb(List<List<Character>> list, List<String> lastList, int index) {
        if (list.size() <= index) return lastList;
        List<String> res = new ArrayList<>();
        List<Character> currList = list.get(index);
        if (index == 0) {
            for (Character c : currList) {
                res.add(c + "");
            }
        } else {
            for (String last : lastList) {
                for (Character c : currList) {
                    res.add(last + c);
                }
            }
        }
        return getAllLetterComb(list, res, index + 1);
    }
}