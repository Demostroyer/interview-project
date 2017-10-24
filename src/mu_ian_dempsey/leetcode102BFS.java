package mu_ian_dempsey;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 *This is simply BFS. I can use a Queue system to perform this! 
 *1) Create an empty queue q
 *2) temp_node = root //start from root
 *3) Loop while temp_node is not NULL
    a) print temp_node->data.
    b) Enqueue temp_node’s children (first left then right children) to q
    c) Dequeue a node from q and assign it’s value to temp_node
 *I will need a List<List<Integer>> to store the val of each node on the same level. 
 **/
public class leetcode102BFS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
 

    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root==null) {return null;}
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        List<List<Integer>> answer= new ArrayList<List<Integer>>();

    	List<List<Integer>> answer2 = new ArrayList<List<Integer>>();
        while(!queue.isEmpty()){
            TreeNode tempNode= queue.poll();
            //now get this val and add it to our List<List<Integer>> answer
            answer.add((List<Integer>) tempNode);
            for(List<Integer> a : answer) {
            	
            }
            
            
            
        }
		return answer;
        
    }
}
