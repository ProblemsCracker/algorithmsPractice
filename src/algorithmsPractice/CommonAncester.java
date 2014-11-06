package algorithmsPractice;

public class CommonAncester {

	public TreeNodeParent findCA(TreeNodeParent a, TreeNodeParent b) {
		if(a == b) return a;
		
		if(isDescendent(a, b)) return a;
		
		if(isDescendent(b, a)) return b;
		
		if(a.mother == null || b.mother == null) return null;
		
		while(a.mother != null && !isDescendent(a, b)) {
			a = a.mother;
		}
		
		//a == root but b is not in the same tree
		if(a.mother == null && !isDescendent(a, b)) return null;
		
		return a;
		
	}
	
	public boolean isDescendent(TreeNodeParent root, TreeNodeParent a) {
		
		if(root == a) return true;
		
		if(root == null) return false;
		
		if(root == a || a == null) return true;
		
		return isDescendent(root.left, a) || isDescendent(root.right, a);
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNodeParent a = new TreeNodeParent(1);
		TreeNodeParent b = new TreeNodeParent(2);
		TreeNodeParent c = new TreeNodeParent(3);
		TreeNodeParent d = new TreeNodeParent(4);
		TreeNodeParent e = new TreeNodeParent(5);
		TreeNodeParent f = new TreeNodeParent(6);
		TreeNodeParent g = new TreeNodeParent(7);
		
		a.left = b;
		a.right = c;
		b.left = d;
		b.right = e;
		c.left = f;
		c.right = g;
		
		b.mother = a;
		c.mother = a;
		
		d.mother = b;
		e.mother = b;
		
		f.mother = c;
		g.mother = c;
		
		CommonAncester test = new CommonAncester();
		
		TreeNodeParent result = test.findCA(e, c);
		
		System.out.println(result.val);
	}

}
