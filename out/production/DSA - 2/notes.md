# BT
> Difference between hashmaps in Java 7 and Java 8
> 
In Java 7  , SBT were used instead they had Linked lists  which was not the most optimal

Q1.) Given an array of sorted integers , in which two values are swapped , find the two swapped values exactly

Q2.) Given a BST where two nodes have been swapped ,fix it.
   , # You will be provided a wrong tree ,u hv to fix it and only thn it bcomes a BST

```dtd  
/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) {
 *      val = x;
 *      left=null;
 *      right=null;
 *     }
 * }
 */
public class Solution {

    TreeNode prev = null;
    TreeNode ans1 = null;
    TreeNode ans2 = null;

    public void solve(TreeNode A , int[] arr){

        if(A == null) return;

        solve(A.left , arr);

        if(prev!= null){

            if(prev.val > A.val){

                if(ans1 == null){
                    ans1= prev;
                    arr[0] = ans1.val;
                    ans2 = A;
                    arr[1] = ans2.val;
                }
                else{
                    ans2 = A;
                    arr[1] = ans2.val;
                }
            }
        }
        prev = A;

        solve(A.right , arr);

    }

    public int[] recoverTree(TreeNode A) {

        int[] ans = new int[2];

        solve(A , ans);

        int temp = ans[0];
        ans[0] = ans[1];
        ans[1] = temp;

        return ans;
    }
}

```