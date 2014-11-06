package algorithmsPractice;

public class CommonAncesterNoMother {

	public TreeNode findCA(TreeNode root, TreeNode a, TreeNode b) {
		if(isDescendence(a, b)) return a;
		if(isDescendence(b, a)) return b;
		
		boolean checkLeftA = isDescendence(root.left, a);
		boolean checkLeftB = isDescendence(root.left, b);
		boolean checkRightA = isDescendence(root.right, a);
		boolean checkRightB = isDescendence(root.right, b);
		
		if(checkLeftA && checkRightB || checkLeftB && checkRightA) return root;
		
		if(checkLeftA) return findCA(root.left, a, b);
		else return findCA(root.right, a, b);
	}
	
	public boolean isDescendence(TreeNode root, TreeNode target) {
		if(root == target) return true;
		
		if(target == null) return true;
		
		if(root == null) return false;
		
		return isDescendence(root.left, target) || isDescendence(root.right, target);
		
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
		c.right = g;
		
		CommonAncesterNoMother test = new CommonAncesterNoMother();
		
		TreeNode result = test.findCA(a, e, d);
		
		System.out.println(result.val);
	}

}
