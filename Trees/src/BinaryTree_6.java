import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;






  class Treenode{
        Treenode left;
        Treenode right;
        int val;
        public Treenode(int val){
            this.val  =val;
            this.right = null;
            this.left = null;

        }
       public static ArrayList<Integer> inorder(Treenode root){
            ArrayList<Integer> ans =new ArrayList<>();
           Stack<Treenode> stack = new Stack<>();
           Treenode curr = root;
           while(!stack.isEmpty() || curr!= null){
               while (curr != null){
                   stack.push(curr);
                   curr = curr.left;
               }
               curr = stack.pop();
               ans.add(curr.val);
               curr = curr.right;
           }
           return ans;
                 }


                 public static ArrayList<Integer> Normal_Preorder(Treenode A){
            ArrayList<Integer> ans  = new ArrayList<>();
            Treenode curr = A;
                     if (A == null) {
                         return ans;
                     }
                     ans.add(A.val);
                     ans.addAll(Normal_Preorder(A.left));
                     ans.addAll(Normal_Preorder(A.right));
                     return ans;
                 }
                 public static ArrayList<Integer> preorder(Treenode A){
                     ArrayList<Integer> ans =new ArrayList<>();
                     Stack<Treenode> stack = new Stack<>();
                     Treenode curr = A;
                     while(!stack.isEmpty() || curr!= null){
                         ans.add(curr.val);
                         while (curr != null){
                             stack.push(curr);
                             curr = curr.left;
                         }
                         curr = stack.pop();

                         curr = curr.right;
                     }
                     return ans;

                 }
      public static ArrayList<Integer> Normalpostorder(Treenode A){
          ArrayList<Integer> ans =new ArrayList<>();
          if (A == null) {
              return ans;
          }
          ans.addAll(Normalpostorder(A.left));
          ans.addAll(Normalpostorder(A.right));
          ans.add(A.val);
          return ans;

      }

      public static ArrayList<Integer> postorder(Treenode root){
          ArrayList<Integer> ans = new ArrayList<>();
          Stack<Treenode> stack = new Stack<>();
          Treenode curr = root;
          Treenode lastVisited = null;

          while (curr != null || !stack.isEmpty()) {
              if (curr != null) {
                  stack.push(curr);
                  curr = curr.left;
              } else {
                  Treenode temp = stack.peek().right;

                  if (temp == null || temp == lastVisited) {
                      temp = stack.pop();
                      ans.add(temp.val);
                      lastVisited = temp;
                  } else {
                      curr = temp;
                  }
              }
          }

          return ans;
      }




     public static void main(String[] args) {
         Treenode tree  = new Treenode(1);
         tree.left = new Treenode(2);
         tree.right = new Treenode(7);
         tree.right.left = new Treenode(5);
         tree.left.left = new Treenode(3);
         tree.left.left.right= new Treenode(4);
         tree.left.left.right.right= new Treenode(5);
         tree.left.left.right.right.right= new Treenode(6);

//         System.out.println(Normal_Preorder(tree));
//         System.out.println(inorder(tree));
//         System.out.println(preorder(tree));
         System.out.println(postorder(tree));
     }
    }




