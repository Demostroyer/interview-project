package mu_ian_dempsey;
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 *
 *Leetcode Q404. 
 *Few Ideas: Check if the root is empty, if so return 0.
 *1.Then as long as the current node has a left child we can traverse down and find the LEFT leaf node
 *2.So check then if the child of the child (grandchild) of our current node has no children(Right or Left), if so add this grandchild val to
 *answer. 
 *3.Else it does have children still, so this grandchild is NOT a leaf node, so traverse through the tree again via a recursive call
 *This will then check again until we find a left leaf node. Or not. 
 *4.Outside of the if from 1 above, we now know that the current node has no more left children. So recursive call on the right child node
 *of the current node, and start again. 
 *@author Ian Dempsey
 *@date 19/10/17
 *Time analysis: O(logn) 
 *Space analysis: O(n) -> because I am storing the entire tree regardless. 
 */
public class sumLeftLeaves404 {
	
	public static void main(String...args) {
		//tree looks like this
		/*
		 10
		/  \
	   9   12
	  /	   /
	 8    11
		 So the answer should be 8+11=19
		 */
	}

    public static int sumOfLeftLeaves(TreeNode root) {
        //if the tree is empty
        if(root == null) 
        	return 0;
        int answer = 0;
        //if the current node has a left child
        if(root.left != null) {
            //the current node's left child has no children. This means the child of the current node is a leaf node
            if(root.left.left == null && root.left.right == null) 
            answer += root.left.val;//add this value to the value of answer
            //Else it's not a leaf node. So answer is added with a recursive call on the current node's left child, going deeper into the tree
            //We know that it has a left child from the code above.
            else 
            	answer += sumOfLeftLeaves(root.left);
        }
        //Finally if the left child of the current node is null, we try to look down the right branch of the tree. Starting again with
        //the right branch having a new 'root' in the current node's right child. 
        answer += sumOfLeftLeaves(root.right);
     return answer;
    }
}