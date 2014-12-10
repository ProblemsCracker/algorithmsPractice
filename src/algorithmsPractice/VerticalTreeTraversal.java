package algorithmsPractice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class VerticalTreeTraversal {
	
	public static List<List<Integer>> traverse(TreeNode root) {
		List<List<Integer>> posLevels = new ArrayList<>();
		List<List<Integer>> negLevels = new ArrayList<>();
		
		if(root == null) return posLevels;
		
		LinkedList<NodeWithLevel> queue = new LinkedList<>();
		
		queue.add(new NodeWithLevel(root, 0));
		
		while(!queue.isEmpty()) {
			NodeWithLevel curNode = queue.pollFirst();
			int curLevel = curNode.level;
			TreeNode curTreeNode = curNode.node;
			
			if(curLevel < 0) {
				int tmp = -curLevel;
				if(negLevels.size() <= tmp - 1) {
					negLevels.add(new ArrayList<Integer>());
				}
				negLevels.get(tmp - 1).add(curTreeNode.val);
			}
			else {
				if(posLevels.size() <= curLevel) {
					posLevels.add(new ArrayList<Integer>());
				}
				posLevels.get(curLevel).add(curTreeNode.val);
			}
			
			if(curTreeNode.left != null) {
				TreeNode left = curTreeNode.left;
				queue.add(new NodeWithLevel(left, curLevel - 1));
			}
			
			if(curTreeNode.right != null) {
				TreeNode right = curTreeNode.right;
				queue.add(new NodeWithLevel(right, curLevel + 1));
			}
		}
		
		for(List<Integer> cur : negLevels) {
			posLevels.add(0, cur);
		}
		
		return posLevels;
		
	} 
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode a1 = new TreeNode(1);
		TreeNode a2 = new TreeNode(2);
		TreeNode a3 = new TreeNode(3);
		TreeNode a4 = new TreeNode(4);
		TreeNode a5 = new TreeNode(5);
		TreeNode a6 = new TreeNode(6);
		TreeNode a7 = new TreeNode(7);
		TreeNode a8 = new TreeNode(8);
		TreeNode a9 = new TreeNode(9);
		
		a1.left = a2;
		a1.right = a3;
		
		a2.left = a4;
		a2.right = a5;
		
		a3.left = a6;
		a3.right = a7;
		
		a6.right = a8;
		a7.right = a9;
		
		List<List<Integer>> result = traverse(a1);
		
		for(List<Integer> cur : result) {
			for(int i : cur) {
				System.out.print(i);
			}
			System.out.println();
		}
		
	}

}
