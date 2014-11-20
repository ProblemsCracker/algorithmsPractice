package algorithmsPractice;

import java.util.Stack;

public class RestoreBST {

	static TreeNode leftNode = null;
    static TreeNode rightNode = null;
    
    public static void recoverTree(TreeNode root) {
        if(root == null) return;
        restore(root);
        if(leftNode != null && rightNode != null) {
            int tmp = leftNode.val;
            leftNode.val = rightNode.val;
            rightNode.val = tmp;
        }
    }
    
    public static void restore(TreeNode root) {
        if(root == null) return;
        
        TreeNode left = root.left;
        TreeNode right = root.right;
        
        restore(root.left);
        
        //find the predecessor
        if(left != null) {
            while(left.right != null) {
                left = left.right;
            }
            //predecessor > root
            if(left.val > root.val) {
                if(leftNode == null)
                    leftNode = left;
                //root == 1 should get in this
                if(rightNode == null || root.val < rightNode.val)
                    rightNode = root;
            }
        }
        
        //find the successor
        if(right != null) {
            while(right.left != null) {
                right = right.left;
            }
            //root > successor
            if(root.val > right.val) {
                if(leftNode == null) 
                    leftNode = root;
                if(rightNode == null || right.val < rightNode.val)
                    rightNode = right;
            }
        }
    
        restore(root.right);
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode a = new TreeNode(3);
		TreeNode b = new TreeNode(1);
		a.right = b;
		TreeNode c = new TreeNode(2);
		b.left = c;
		
		recoverTree(a);
		
		Stack<TreeNode> stack = new Stack<>();
		
		while(a != null) {
			stack.push(a);
			a = a.left;
		}
		
		while(!stack.isEmpty()) {
			TreeNode cur = stack.pop();
			System.out.println(cur.val);
			TreeNode right = cur.right;
			while(right != null) {
				stack.push(right);
				right = right.left;
			}
		}
		
	}

}
