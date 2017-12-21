package mu_ian_dempsey;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/*
 * Leetcode Q 102. Description: Given a binary tree, return the level order traversal of its nodes' values.
 *This is simply BFS. I can use a Queue system to perform this! It will be altered though 
 *1) Create an empty queue q
 *2) temp_node = root //start from root
 *3) Loop while temp_node is not NULL
    a) print temp_node->data.
    b) Enqueue temp_node’s children (first left then right children) to q
    c) Dequeue a node from q and assign it’s value to temp_node
 *I will need a List<List<Integer>> to store the val of each node on the same level. 
 *Use a queue structure(q) to store the nodes, then check this queue for all nodes that are in it. 
 *For each of these nodes add , check if their children are null. If not enqueue them to a second queue structure (q2)
 *Repeat this on all nodes in the original queue(q), adding all children to q2. 
 *Then outside of the for loop, need to update q1 to be q2. 
 *Also might need a temp variable to hold in the values of the children nodes that are being added to q2. 
 *These values are the ones which must be returned. I can put the add(node.val) inside the for loop. This allows
 *all the values of the children to be added at the same step, meaning they will be outputted on the same level. 
 *@author Ian Dempsey
 *@date 23/10/17
 *Pattern : Breadth First Search
 *Time Analysis: O(n^2) -> it has to go through the queue multiple times, in the two loops 
 *Space Analysis: O(n) -> all depends on the input of the root. 
 */
public class leetcode102BFS {

	public static void main(String[] args) {
	}
 

    public List<List<Integer>> levelOrder(TreeNode root) {
        //using the Queue system to go through the given elements, it will never have any null nodes on it
    	ArrayList<TreeNode> queue = new ArrayList<TreeNode>();
    	List<List<Integer>> answer= new ArrayList<List<Integer>>();//to store the answer, the elements in the tree itself
    	if(root==null) 
    		return answer; //base case
    	queue.add(root);//straight away add in the root, then we go from here
    	//whilst there is something on the queue, this means there are elements in the queue and in the tree
    	while(!queue.isEmpty()){
    		//set 2 variables do the traversal and checking of the children nodes. 
    		List<Integer> temp = new ArrayList<Integer>();//holds the nodes that are to be added into our level ordering 
    		ArrayList<TreeNode> curr = new ArrayList<TreeNode>();//this is the current level we are at
    		for(int i =0; i< queue.size();i++) {//only go up to the size of the queue at the moment
    			temp.add(queue.get(i).val);//get each node's value which is on the queue itself. it will be added to answer.
    			/*these 2 conditionals will check if the current node has any children
      			if so it then add them to the curr Arraylist. this list acts as a temp storage for the Queue. 
      			It only holds nodes which are non-null*/
    			if(queue.get(i).left !=null) 
    				curr.add(queue.get(i).left);
    			if(queue.get(i).right !=null) 
    				curr.add(queue.get(i).right);
    		}          
    		answer.add(temp);//add the correct nodes to answer from temp
    		queue=curr;//set the queue to now have the elements inside curr
    	}
    	return answer;
    	}
	}
