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
 *Then in main function: Set the returned index val to root
 *Split the main array into two subarrays of nums, leftSub and rightSub
 *Loop over each element in each array, creating a node for each value, and adding into the tree structure
 *so left of root for leftSub, right for rightSub
 *finally return the root.
 *
 *@author Ian Dempsey
 *@date 27/10/17 
 */

/**
 * Solution done by Hao Wu, comments by Ian Dempsey
 * Recursively solve each subproblem. I find this is quite similar to merge sort pattern. Note the key point I made.
 * This is a little bit tricky: you need make sure the array shrinks everytime go into the recursive call.
 * The rest should be straightforward, just take advantage of post-order traversal.
 * Pattern: Mergesort variant
 * Time Analysis: O(n) -> Based on the size of the array given.
 * Space Analysis: O(n *m) -> based on n, the size of the array given, and m the number of recursive calls required to solve the problem.
 */


public class MaximumBinaryTree654 {
        public TreeNode constructMaximumBinaryTree(int[] nums) {    
    	if (nums.length==0) 
    		return null;
        int max = nums[0];//the biggest number which is the root
        int j=0;//the index of the root, will be used for splitting later on
        for (int i=1;i<nums.length;i++){//finding the biggest number -> root. Also setting j to i. 
            if (nums[i]>max) 
            max = nums[i];j=i;
        }
        //creating the node of the current max, will be updated everytime I recursively call this method. 
        TreeNode node = new TreeNode(max);
        //creating the left subarray, it is a range of 0 up to j(from earlier), this is EXCLUSIVE on j.
        int[] left = Arrays.copyOfRange(nums,0,j);
        //the left node is created by calling this method but on the left subarray, this will work until it is null.Again finding the 'root' of the subarray 
        node.left = constructMaximumBinaryTree(left);
        //Only fires when the left subarray is null,the key here is to go from one AFTER the original root, upto the end of the original array 
        int[] right = Arrays.copyOfRange(nums,j+1,nums.length); //key point, keep array shrinks everytime.
	//the right node is created via a recursive call on the right subarray, It finds the 'root' of this subarray everytime. 
        node.right = constructMaximumBinaryTree(right);
     	return node;
    }
        /*public TreeNode constructMaximumBinaryTree(int[] nums) {
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
    }*/
	
}
