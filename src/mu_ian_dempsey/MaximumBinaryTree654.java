package mu_ian_dempsey;

import java.util.Arrays;

/**
 * This is leetcode Q 654. Nearly Complete. 
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 *
 *Idea: Hleper function to find the index of the max number. Return the index.
 *Then in main function: Set the returned index val to root
 *Split the main array into two subarrays of nums, leftSub and rightSub
 *Loop over each element in each array, creating a node for each value, and adding into the tree structure
 *so left of root for leftSub, right for rightSub
 *finally return the root.
 *
 *@author Ian Dempsey
 *@date 27/10/17
 *Time Analysis:
 *Space Analysis: 
 */
public class MaximumBinaryTree654 {
	    public TreeNode constructMaximumBinaryTree(int[] nums) {
	        int rootIndex=findRoot(nums,0,nums.length);
	        TreeNode root = new TreeNode(nums[rootIndex]);//create a TreeNode that is the root itself
	        root.val=nums[rootIndex];//set the val of root ot the biggest value in the array
	        //now to create the actual tree structure
	        //use : int[] newArray = Arrays.copyOfRange(oldArray, startIndex, endIndex);
	        int[] leftSub = Arrays.copyOfRange(nums,0,rootIndex-1);//don't include the root
	        int[] rightSub = Arrays.copyOfRange(nums,rootIndex+1, nums.length);//don't include the root
	        TreeNode curr = root;//a copy, used to go through and add everything in
	        for(int i : leftSub){
	            TreeNode left = new TreeNode(i);//create the left node
	            left.val=i;//give the left node it's value
	            curr.left=left;//add the left node to the tree
	            curr=curr.left;//and move the pointer onwards, so we are always at a leaf node
	        }
	        curr=root;//reset curr
	       for(int i : rightSub){
	            TreeNode right = new TreeNode(i);//create the right node
	            right.val=i;//give the right node it's value
	            curr.right=right;//add the right node to the tree
	            curr=curr.right;//and move the pointer onwards, so we are always at a leaf node
	        }
	        
	        return root;//return the root node
	    }
	    
	    public int findRoot(int[]nums,int start,int end){
	        int currentMax=nums[0];//before we start the max is at the start
	        int index=0;
	        for(int i =0;i< end-1;i++){
	            //if current value is smaller than the value found at position i of nums, update currentMAX
	            if(currentMax < nums[i]){
	                currentMax=nums[i];
	                index=i;
	            }
	        }//once it has looped through return currentMax. This should work in the case that the first position of the array is the biggest num
	        return index;
	    }
}
