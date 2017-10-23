package mu_ian_dempsey;

/**
 * Used with some of the questions based on the Tree Data Structure
 * I have included some basic functionality besides simply being able to instantiate this class.
 * This includes the ability to insert into the tree structure. 
 * @author LeetCode.com, Ian Dempsey
 * @date 23/10/17
 */
public class TreeNode {
	int val;
	TreeNode root;
	TreeNode left;
	TreeNode right;
	TreeNode(int x){val=x;}
	
	//default constructor
	public TreeNode() {
		
	}
	//adding in an insert method just so I can test out that my maxDepth function and others works!
	public void insert(int key) {
		TreeNode newNode= new TreeNode();
		newNode.val=key;
		if(root==null) {//if the tree is empty so far
			root=newNode;
			
		}else {
			TreeNode current =root;
			TreeNode parent;
			while(true) {
				parent =current;
				if(key<current.val) {
					current=current.left;
					//this is where it should go as the position it should be in is found to be empty
					if(current==null) {
						parent.left=newNode;
						return;
					}
				}else {
					current=current.right;
					//this is where it should go as the position it should be in is found to be empty
					if(current==null) {
						parent.right=newNode;
						return;
					}
				}
				
			}
		}
		
	}

}
