package mu_ian_dempsey;

public class longestUnivaluePath687 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode tree= new TreeNode(5);
		tree.insert(4);
		tree.insert(5);
		tree.insert(1);
		tree.insert(1);
		tree.insert(5);
		int answer = longestUnivaluePath(tree);
		System.out.println(answer);

	}
	static int count = 0;
    public static int longestUnivaluePath(TreeNode root) {
        getCount(root);
        return count;
    }
    public static int getCount(TreeNode root) {
        if(root == null) 
        	return 0;
        int left = getCount(root.left);
        int right = getCount(root.right);
        int leftCur = 0;
        int rightCur = 0;
        if(root.left != null && root.val == root.left.val) {
            leftCur += 1 + left;
        }
        if(root.right != null && root.val == root.right.val) {
            rightCur += 1 + right;
        }
        count = Math.max(count, leftCur + rightCur);
        return Math.max(leftCur, rightCur);
    }
}
