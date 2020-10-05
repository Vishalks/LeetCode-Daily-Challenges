//TC: O(words*avg length of each word) + O(length of stream)
//SC: O(words*avg length of each word)
class TrieNode {
    Map<Character, TrieNode> children = new HashMap();
    boolean word = false;
}

class StreamChecker {
    TrieNode trie = new TrieNode();
    //Deque<Character> stream = new ArrayDeque();
    List<Character> stream = new ArrayList();

    public StreamChecker(String[] words) {
        for(String word: words){
            TrieNode node = trie;
            String reverseWord = new StringBuilder(word).reverse().toString();//store words in reversed order in trie for ease of searching
            for(char ch: reverseWord.toCharArray()){
                if(!node.children.containsKey(ch)){
                    node.children.put(ch, new TrieNode());
                }
                node = node.children.get(ch);
            }
            node.word = true;
        }
    }
    
    public boolean query(char letter) {
        //stream.addFirst(letter);
        stream.add(0,letter);//always add query letter to start of list
        TrieNode node = trie;
        for(char ch: stream){
            if(node.word){//found the word
                return true;
            }
            if(!node.children.containsKey(ch)){//letter is not in  trie
                return false;
            }
            node = node.children.get(ch);
        }
        return node.word;
    }
}

/**
 * Your StreamChecker object will be instantiated and called as such:
 * StreamChecker obj = new StreamChecker(words);
 * boolean param_1 = obj.query(letter);
 */