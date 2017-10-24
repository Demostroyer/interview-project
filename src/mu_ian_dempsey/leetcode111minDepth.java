package mu_ian_dempsey;

import java.util.LinkedList;
import java.util.Queue;

/**
 * This is leetcode Q 111.
 *Condition to be a leaf node is: focusNode.left == null AND focusNode.right==null.
 *I can actually use BFS. 
 *Idea here being that the first instance of a leaf node I come across on the tree IS the shortest path. 
 *This is true because of the check I use : if(tempNode.left == null && tempNode.right==null). This tells me that this branch goes no further
 *And since no other branch has validated this conditional, then the previous branches all have children still. 
 *Slightly altered algorithm for BFS:
 	1) Create an empty queue q
	2) temp_node = root /start from root/
	3) Loop while temp_node is not NULL
    	a) Enqueue temp_node’s children (first left then right children) to q
    	b) Dequeue a node from q and assign it’s value to temp_node
 *The pattern here is : Breadth-First-Search
 *Time analysis: O(n) -> because I have a simple Queue data structure, and a tree. This remains n
 *Space analysis: O(n) ->Creating the extra queue does not require a lot of space, so little effect on the output. 
 */
public class leetcode111minDepth {
	public static void main(String... args) {
		TreeNode tree = new TreeNode();
		tree.insert(10);
		tree.insert(2);
		tree.insert(12);
		tree.insert(11);
		tree.insert(5);
		tree.insert(13);
		tree.insert(15);
		System.out.println("The minimum depth of tree is: " );
		System.out.println(minDepth(tree.root));
	}
    public static int minDepth(TreeNode root) {
            //first check if root is null, return 0 if so
            if(root==null) return 0;
           
	    	//Step 1 above
	        Queue<TreeNode> queue = new LinkedList<TreeNode>();
	        //Adding in the root so I have somewhere to start, Step 2
	        queue.add(root);
            int answer=1;//it would have at least 1 if the root was not NULL. and we have now inserted an element into the queue
	        //if the root was actually nonempty
	        while (!queue.isEmpty()) 
	        {
                int size=queue.size();
                for(int i =0; i<size; i++){
	            	//Remove the current head of the queue, then print it
	            	//Step 3b) above
	                /* poll() removes the present head.*/
	                TreeNode tempNode = queue.poll();
                    //now to check if it is a leaf node
                    if(tempNode.left == null && tempNode.right == null){
                        return answer;
                    }
	                //just check where currently am
	                //System.out.print(tempNode.val + " ");
	                //Step 3a) above
	                /*Enqueue left child */
	                if (tempNode.left != null) {
	                 queue.add(tempNode.left);
	                }

	                /*Enqueue right child */
	                if (tempNode.right != null) {
	                    queue.add(tempNode.right);
	                }
                }
                //after doing these enqueues, add one to answer var as we were on a new level
                answer++;
	    }
        return answer;
    }
}
