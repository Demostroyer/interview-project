package mu_ian_dempsey;

import java.util.Stack;
/**
 *Can build on the answer from 94. Only difference is that there is no need for the List. 
 *Also, need to perform some decrement on k everytime a move is made. 
 *Need to go left AND right. May need to even go right from the root after traversing the entire left subtree, 
 *as the kth element could be there. Take note of this.
 *@author Ian Dempsey
 *date:28/11/17
 *Pattern here is : tree traversal. 
 *Time Analysis: O(m^2) m is the second while loop, which has an inner while loop, which in the worst case will have to execute. 
 *Space Analysis: O(n) -> n being the Stack which will hold at most n elements.
 */

public class kthSmallestElementinaBST230 {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> myStack = new Stack<>();

        while(root!=null){//push everything from the left subtree onto the stack. This will allow the elements to be the smallest ones.
            //This also allows the stack to go from smallest->biggest. Smallest is at the top.
            myStack.push(root);
            root=root.left;//keep moving left. 
        }        
        //once it has reached null, need to move right!
        //Can perform the searching straight away, as the smallest ones have been added, so chances are it has already been added on the stack
        while (k != 0) {
            TreeNode n = myStack.pop();
            k--;//as a node has been popped off of the stack, decrement k, as we are getting closer to k being 0.
            if (k == 0) return n.val;//When k is 0, then just return the current node's value.
            //The following is in the chance that it has not been found in the entire left subtree, so it must be in the right subtree
            TreeNode right = n.right;
            while (right != null) {
                myStack.push(right);//push onto the stack the right node, so can go down subtree instead
                right = right.left;//then go left again, allowing
            }
        }
        return -1;//Not found
    }

}
