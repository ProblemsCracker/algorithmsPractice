package algorithmsPractice;

public class MaxPathSum {
	/**
	 * Time complexity is O(n) and n is the number of TreeNode in this tree 
	 * because each node will be visit once in this function
	 * @param root
	 * @return
	 */
	public int calcuSum(TreeNode root) {
		if(root == null) return 0;
		
		int left = calcuSum(root.left);
		int right = calcuSum(root.right);
		
		return root.val + Math.max(left, right);
		
	}
	
	/**
	 * test main function
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(1);
		TreeNode node1 = new TreeNode(-10);
		TreeNode node2 = new TreeNode(10);
		root.left = node1;
		root.right = node2;
		node1.left = new TreeNode(100);
		node1.right = new TreeNode(1);
		node2.left = new TreeNode(20);
		node2.right = new TreeNode(15);
		
		MaxPathSum test = new MaxPathSum();
		
		System.out.println(test.calcuSum(root));
		
	}

}
