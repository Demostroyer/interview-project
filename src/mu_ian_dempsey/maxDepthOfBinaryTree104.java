package mu_ian_dempsey;
/**
 * This is for leetcode Q: 104 Description: 
 * Given a binary tree, find its maximum depth.
 * Idea:  1. Check if the given node to start is empty, therefore return 0. 
 * 2. Else, going to recursively go down both sides of the given tree UNTIL it is null. 
 *  Then back propagate the values to 2 ints storing both results for the left and right subtrees. 
 *  3. Check which one is bigger. Return the bigger value. 
 *  Note, add 1 to the bigger value to get the true level value. 
 *  Pattern here: Depth-First Search
 *  Time analysis: O(n) -> because I must traverse the entire tree to find the depth.
 *  Space analysis: O(n) -> because I am not using anymore space, so just storing the tree once. 
 *  @author Ian Dempsey
 *  @date: 23/10/17
 */

public class maxDepthOfBinaryTree104 {

	public static void main(String[] args) {

	}
	/* Compute the "depth" of a tree -- the number of
    nodes along the longest path from the root node
    down to the farthest leaf node.*/
    static int depth(TreeNode focusNode)
    {
        if (focusNode == null)
           return 0;
        else
        {
        	/*This works by going as far left, until you find a node with no left child. 
        	 * then seeing if this parent node has a right child. 
        	 * If so it again tries to go left from this right child, then right when it has no left child etc 
        	 * until it returns a 0 for a node having no children. 
        	 * This then moves onto the right subtree and performs the same task but it in the opposite style.
        	 * */
            /* compute  depth of each subtree */
            int ldepth = depth(focusNode.left);
            int rdepth = depth(focusNode.right);
            
            /* use the larger one */
            if (ldepth > rdepth)
                return(ldepth+1);
            else return(rdepth+1); 
        }
    }
}