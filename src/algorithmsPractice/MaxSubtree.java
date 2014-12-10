package algorithmsPractice;

public class MaxSubtree {

	public static NodeWithSubtreeNum findSubtree(TreeNode root, int min, int max) {
		
		if(root == null) return new NodeWithSubtreeNum(0, null);
		
		//leave
		if(root.left == null && root.right == null) {
			return new NodeWithSubtreeNum(1, root);
		}
		
		NodeWithSubtreeNum left = findSubtree(root.left, min, max);
		NodeWithSubtreeNum right = findSubtree(root.right, min, max);
		
		if(left == null) return right;
		if(right == null) return left;
		
		if(left.node == root.left && right.node == root.right && root.val >= min && root.val <= max) {
			int curNum = left.num + right.num + 1;
			return new NodeWithSubtreeNum(curNum, root);
		}
		else {
			if(left.num > right.num) {
				return left;
			}
			else {
				return right;
			}
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode t5 = new TreeNode(5);
		TreeNode t3 = new TreeNode(3);
		TreeNode t2 = new TreeNode(2);
		TreeNode t4 = new TreeNode(4);
		TreeNode t100 = new TreeNode(100);
		TreeNode t50 = new TreeNode(50);
		TreeNode t25 = new TreeNode(25);
		TreeNode t75 = new TreeNode(75);
		TreeNode t12 = new TreeNode(12);
		TreeNode t37 = new TreeNode(37);
		TreeNode t30 = new TreeNode(30);
		TreeNode t40 = new TreeNode(40);
		
		t5.left = t3;
		t5.right = t100;
		
		t3.left = t2;
		t3.right = t4;
		
		t100.left = t50;
		t50.left = t25;
		t50.right = t75;
		
		t25.left = t12;
		t25.right = t37;
		
		t37.left = t30;
		t37.right = t40;
		
		NodeWithSubtreeNum result = findSubtree(t5, 4, 75);
		
		System.out.println(result.node.val + " " + result.num);
		
	}

}
