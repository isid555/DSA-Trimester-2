 class Trie {
     public  Trie(){

     }


    class Node{
        Node[] children = new Node[26];
        boolean isWord;

    }
    Node root = new Node();




     public void insert(String word){
         Node curr = root;
        for(int i = 0;i<word.length();i++){
            int index = word.charAt(i)-'a';
            if(curr.children[index] == null){
                curr.children[index] = new Node();

            }
            curr = curr.children[index];

        }
         curr.isWord = true;

     }
     public boolean search(String word){
            Node node = getPrefixNode(word);
            return node!= null ? node.isWord : false;
     }
     public boolean startsWith(String prefix){
            Node node = getPrefixNode(prefix);
            return node!=null;
     }


     public Node getPrefixNode(String prefix){
         Node curr = root;
         for (int i = 0; i < prefix.length() && curr!=null; i++) {
             int index = prefix.charAt(i)-'a';
             curr = curr.children[index];

         }
         return curr;
     }


}
