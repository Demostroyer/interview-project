package mu_ian_dempsey;

import java.util.ArrayList;
import java.util.List;

/**
*So this is similar to the Inorder Traversal Q94.
*But I have learned a bit more about ArrayLists. I can use the addAll function to append a whole collection. 
*This can be utilised to follow the order of Preorder: root->left subtree->right subtree.
*By initially adding the root using add() i can then just use the addAll() function once on each subtree.
*@author Ian Dempsey
*date:22/1/2017
*Pattern: Tree Traversal
*Time analysis: O(n)
*/
public class binaryTreePreorderTraversal144 {
	
    public List<Integer> preorderTraversal(TreeNode root) {
        
        List<Integer> myList = new ArrayList<>();//the data structure to hold everything
        if(root==null) return myList;//base case.
        myList.add(root.val);//adding the root initially.
        myList.addAll(preorderTraversal(root.left));//now go left and add ALL of the left subtree, addAll() works on Collections
        myList.addAll(preorderTraversal(root.right));//now go right and add ALL of the right subtree, addAll() works on Collections
        return myList;//return the completed Preorder traversal
    }
}

