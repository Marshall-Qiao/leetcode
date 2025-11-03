class TrieNode {
    boolean end = false;
    TrieNode[] childs = new TrieNode[26];
}

class Trie {
    
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        if (word == null) return;
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (node.childs[idx] == null) {
                node.childs[idx] = new TrieNode(); 
            }
            node = node.childs[idx];
        }
        node.end = true;
    }
    
    public boolean search(String word) {
        if (word == null) return false;
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (node.childs[idx] == null) {
                return false;
            }
            node = node.childs[idx];
        }
        return node.end;
    }
    
    public boolean startsWith(String prefix) {
        if (prefix == null) return false;
        TrieNode node = root;
        for (int i = 0; i < prefix.length(); i++) {
            int idx = prefix.charAt(i) - 'a';
            if (node.childs[idx] == null) {
                return false;
            }
            node = node.childs[idx];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */