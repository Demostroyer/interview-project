package mu_ian_dempsey;
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 *So if we ever get to a node that has a val outside of the two given limits(L, R), we know that the tree is either left of it in the case of
 *R and right of it in the case of L. Just need to keep on calling the function recursively when this happens. With the root being passed in 
 *as the updated root which is either moved left(if it voilated R) and vice versa. 
 *If neither of these happen, then just move onwards via a recursive call. This is odd, and must ask Hao about it
 */
public class TrimBinarySearchTree669 {

	    public TreeNode trimBST(TreeNode root, int L, int R) {
	        if(root==null)return null;
	        //if the current node is outside of the limit of R, move left! L and R never change
	        if(root.val > R){
	            return trimBST(root.left,L,R);
	        }
	        //if the current node is outside of L, then go right
	        if(root.val<L){
	            return trimBST(root.right,L,R);
	        }
	        //with just the two above, it will never move through the entire tree . Must trim it separately if these two above are never fired
	        //i believe this is adding the ALLOWED nodes onto the new tree itself. Wheras above discards them by never
	        //saving them. Must verify this with Hao
	        root.left=trimBST(root.left,L,R);
	        root.right=trimBST(root.right,L,R);
	        return root;
	        
	    }
	    
}
