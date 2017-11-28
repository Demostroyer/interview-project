package mu_ian_dempsey;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 *
 *Idea: Just go through it in inorder traversal, so left subtree, root, then right subtree. 
 *Can use a Stack to pop() and push() the nodes as we traverse them in inorder traversal. 
 *Whilst the tree still has nodes OR the stack is not empty, traverse the tree. Need to go left until it reaches left. 
 *So have an inner while loop, which pushes the current node onto the stack, then moves left.
 *When this inner loops guard fails, this means we can't go left anymore, so go right. 
 *But first pop() off the node currently on the stack. The LIFO principle is important to the choice of Stack. 
 *As the last element is the smallest in this subtree, as it was the last node pushed in after going left and before hitting null.
 *So pop() off the node, then add in this node's val to the list. 
 *Then finally go right to move onto the next subtree. 
 *@author: Ian Dempsey
 *date:28/11/17
 *Pattern here is tree traversal.
 *Time Analysis: O(n) ->depends on the size of the tree given.
 */
public class binaryTreeInorderTraversal94 {

	    public List<Integer> inorderTraversal(TreeNode root) {
	        List<Integer> myList = new ArrayList<>();
	        if(root==null)return myList;//it would be empty at this stage
	        Stack<TreeNode> myStack = new Stack<>();
	        while(root!=null||!myStack.empty())//whilst we still have nodes to traverse
	        {
	            while(root!=null){//now go through the tree itself, and we push the nodes onto the stack
	                myStack.push(root);//pushing it onto the stack, this will be used later.
	                root=root.left;//go left until we can't go left anymore, this will validate the guard here
	            }
	            root=myStack.pop();//get the biggest node in the tree. Add it to the list now
	            myList.add(root.val);
	            root=root.right;//go to the right, this will allow the tree to be full traversed
	        }
	        return myList;
	    }
}