import java.util.HashMap;

public class Trie1 {
    public class TrieNode{
        HashMap<Character,TrieNode> map;
        boolean isEnd;
        public TrieNode(){
            HashMap map =  new HashMap<Character,TrieNode>();
            boolean isEnd = false;
        }
        public void insert(TrieNode root,String word){
            HashMap<Character,TrieNode> map = new HashMap<>();
            TrieNode curr = root;
            for (int i = 0; i < word.length(); i++) {
               char ch = word.charAt(i);
                if(!map.containsKey(ch)){
                   map.put(ch,new TrieNode());
                }
                curr = map.get(ch);
                
            }
        }
    }

}