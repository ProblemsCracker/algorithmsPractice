package algorithmsPractice;

import java.util.LinkedList;

public class MirrorBinaryTree {

	public void mirror(TreeNode root) {
		if(root == null) return;
		
		mirror(root, root.left, root.right);
	}
	
	public void mirror(TreeNode parent, TreeNode left, TreeNode right) {
		if(parent == null) return;
		parent.left = right;
		parent.right = left;
		mirror(parent.left);
		mirror(parent.right);
	}
 	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode a = new TreeNode(1);
		TreeNode b = new TreeNode(2);
		TreeNode c = new TreeNode(3);
		TreeNode d = new TreeNode(4);
		TreeNode e = new TreeNode(5);
		TreeNode f = new TreeNode(6);
		TreeNode g = new TreeNode(7);
		
		a.left = b;
		a.right = c;
		b.left = d;
		b.right = e;
		c.left = f;
		//c.right = g;
		
		MirrorBinaryTree test = new MirrorBinaryTree();
		
		test.mirror(a);
		
		LinkedList<TreeNode> queue = new LinkedList<>();
		
		queue.addLast(a);
		
		while(!queue.isEmpty()) {
			TreeNode curNode = queue.pollFirst();
			System.out.println(curNode.val);
			if(curNode.left != null)
				queue.addLast(curNode.left);
			if(curNode.right != null)
				queue.addLast(curNode.right);
		}
		
		System.out.println();
	}

}
