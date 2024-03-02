import java.util.ArrayList;
import java.util.Arrays;

public class Binary_trees {



    class Treenode{
        Treenode left;
        Treenode right;
        int val;
        public Treenode(int val){
            this.val  = val;
            this.left = null;
            this.right = null;
        }




//        =========== COde ===================


        public void main(String[] args) {
//            int [] arr = {1,4,3,2,5};
//            System.out.println(Arrays.toString(Swapped_array(arr)));



            //Tree
            Treenode tree = new Treenode(11);
            tree.left = new Treenode(6);
            tree.right = new Treenode(15);
            tree.left.left = new Treenode(2);
            tree.right.right = new Treenode(9);
            tree.left.right = new Treenode(21);
            tree.right.right.left = new Treenode(18);
            correct_Swapped(tree);

        }
        public static int[] Swapped_array(int[] A){
            int temp  =0;
            int [] ans = new int[2];
            for (int i = 0; i < A.length-1; i++) {
                if(A[i]>A[i+1]){
                    ans[0] = A[i];
                    temp = i;
                    break;
                }
            }
            for(int i =temp+1 ; i<A.length-1;i++){
                if(A[i]<A[i+1]){
                    ans[1] = A[i];

                }
            }
            return ans;
        }
        //Q.) Given a Binary tree where two nodes have been swapped  find it and fix it

        public  static ArrayList<Integer> inorder(Treenode A){
            ArrayList<Integer> ans = new ArrayList<>();
            if(A == null){
                return ans;
            }
            ans.addAll(inorder(A.left));
            ans.add(A.val);
            ans.addAll(inorder(A.right));
            return ans;
        }
        public static ArrayList<Integer> correct_Swapped(Treenode A){
            ArrayList<Integer> ans = inorder(A);
            ArrayList<Integer> temp = new ArrayList<>();
            for (int i = 0; i < ans.size()-1; i++) {
                if(ans.get(i) > ans.get(i+1)){
                    temp.add(ans.get(i+1));
                }
            }
//            int [] das = new int[2];
//            das[0] = temp.get(0);
//            das[1] = temp.get(1);
            return  temp;
        }
}

    }
