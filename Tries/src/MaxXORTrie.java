import java.util.ArrayList;

class TrieNode {
    TrieNode[] children;

    public TrieNode() {
        children = new TrieNode[2];
    }
}

public class MaxXORTrie {
    private TrieNode root = new TrieNode();
    private static final int BITS = 31;

    public void insert(int num) {
        TrieNode node = root;
        for (int i = BITS; i >= 0; i--) {
            int bit = (num >> i) & 1;
            if (node.children[bit] == null) {
                node.children[bit] = new TrieNode();
            }
            node = node.children[bit];
        }
    }

    public int findMaxXOR(int num) {
        TrieNode node = root;
        int maxXOR = 0;

        for (int i = BITS; i >= 0; i--) {
            int bit = (num >>> i) & 1;
            int flipBit = 1 - bit; // Flip the bit to maximize XOR
            if (node.children[flipBit] != null) {
                maxXOR |= (1 << i);
                node = node.children[flipBit];
            } else {
                node = node.children[bit];
            }
        }

        return maxXOR;
    }

    public static void main(String[] args) {
        // Maximum Xor in an Array
        MaxXORTrie trie = new MaxXORTrie();
        int[] nums = {1,4,3};

        for (int num : nums) {
            trie.insert(num);
        }

        ArrayList<Integer> ans = new ArrayList<>();
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length ; j++) {
                max = Math.max(max , trie.findMaxXOR(nums[j]));


            }
        }
//        System.out.println(max);


        int sample[] = new int[]{};
        for (int i = 0; i < 14; i++) {
            sample[i] = i;
        }
        for (int i = 0; i < sample.length; i++) {
            System.out.println(sample[i]);
        }

        // Maximum Xor in Sub-Arrays
        
    }
}