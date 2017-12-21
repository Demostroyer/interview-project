package mu_ian_dempsey;
/**
 * Q687. Description: 
 * Given a binary tree, find the length of the longest path where each node in the path has the same value. 
 * This path may or may not pass through the root.
 * Idea:
 * Can solve this using recursion. Checking if the root is null. That is the base case. 
 * We want to go left as far as possible, so that we find the longest paths.
 * We will need to take into account the root node, so a conditioanl check to see if the values are equal.
 * If they are then we just +1 to total.
 * Then need to perform a math.max() on the two stored int for the paths. 
 * Return the biggest.  
 * Answer supplied by leetcode.
 * Time Complexity: O(N) where N is the number of nodes in the tree. We process every node once.
 * Space Complexity: O(H), where H is the height of the tree. Our recursive call stack could be up to H layers deep.
 */

public class longestUnivaluePath687 {

	public static void main(String[] args) {
	}
	static int count = 0;
    public static int longestUnivaluePath(TreeNode root) {
        getCount(root);
        return count;
    }
    public static int getCount(TreeNode root) {
        if(root == null) 
        	return 0;//base case
        int left = getCount(root.left);//keep going left, find the total for this path
        int right = getCount(root.right);//keep going right, find the total for this path
        int leftCur = 0;
        int rightCur = 0;
        if(root.left != null && root.val == root.left.val) {
            leftCur += 1 + left;//update the leftCounter, taking into account the extra node,root.
        }
        if(root.right != null && root.val == root.right.val) {
            rightCur += 1 + right;//update the rightCounter, taking into account the extra node,root.
        }
        //We want to get the max number between 
        count = Math.max(count, leftCur + rightCur);
        return Math.max(leftCur, rightCur);
    }
}
