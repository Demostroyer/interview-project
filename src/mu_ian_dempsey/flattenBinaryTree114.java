package mu_ian_dempsey;
/**
 *Leetcode Q114.
 *The solution is a pre-order traversal of the tree
 *So root, left subtree, then right subtree
 *Note: this Q does not actually require a linked list to be returned. 
 *Idea: Check if it is null, base case.
 *(Issue I keep getting is there should be some nulls in the output. These nulls are from the old LEFT children of the tree, which are no longer in the outputted linked list display. So I must set root.left = null; at some stage. )
 *Recursively go through the left and right subtrees. 
 *This can be done by calling root.left, root.right. Set these to two vars to hold the data
 *As the linked list only contains right children, there must be a point where root.right is set to the left tree. 
 *This must be done before the right subtree is filled into the final linked list, as the left subtree is smaller than the right subtree. 
 *Can use another TreeNode that stores where we currently are looking inside the subtrees. 
 *Then go through this new TreeNode, and move through until we reach null, 
 *this has then gone through the entire left subtree and reached the end. 
 *So now is when the right subtree is added in, as all values in the right sub tree are bigger than the left subtree.
 *
 *@author Ian Dempsey
 *
 *Pattern found: pre-order tree traversal
 *Time Analysis: O(n) -> This only gets bigger, the bigger the input data is. 
 *Space Analysis: O(n) -> because the size of the inputted data is the factor.
 */

public class flattenBinaryTree114 {
		    public void flatten(TreeNode root) {
	        if(root==null) {return;}
	        TreeNode leftSub = root.left;//these two variables are used to cycle through the tree.
	        TreeNode rightSub = root.right;
	        root.left=null;//as it is only the right children that are taken into account.
	        //recursively move through.
	        flatten(leftSub);//left subtree
	        flatten(rightSub);//right subtree
	        root.right=leftSub;//now set it so the left sub tree will be before the right subtree, we do this by overwriting the right subtree to be the old left subtree. Later on just cycle through this list, and have it such that the old right subtree is stuck on after the end of the old left subtree: 
	        TreeNode current = root;
	        while(current.right!=null)current=current.right;//go to the end of the leftsubtree.
	        current.right = rightSub;//now can fill in the right subtree contents.
	    }
	}
