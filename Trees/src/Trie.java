import java.util.ArrayList;

class TrieNode{
    TrieNode children[];
    int count;
    public TrieNode(){
        this.children = new TrieNode[26];
        this.count = 0;
    }
}
public ArrayList<String> prefix(ArrayList<String> A){
    TrieNode root =new TrieNode();
    ArrayList<String> ans = new ArrayList<>();
    //Build Trie
    for (String word :A){
        TrieNode curr = root;
        for(char c :word.toCharArray()){
            int index = c - 'a';
            if (curr.children[c - 'a'] == null) {
                curr.children[c- 'a'] = new TrieNode();

            }
            curr = curr.children[c-'a'];
            curr.count++;
        }
    }

    //Finding shortest unique prefixes
    for (String word :A){
        TrieNode curr = root;
        StringBuilder prefix = new StringBuilder();
        for (char c : word.toCharArray()) {
            prefix.append(c);
            curr = curr.children[c - 'a'];
            if(curr.count == 1){
                break;
            }
        }
        ans.add(prefix.toString());
    }
    return ans;
}