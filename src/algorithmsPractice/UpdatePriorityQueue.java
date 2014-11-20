package algorithmsPractice;

import java.util.Comparator;
import java.util.PriorityQueue;

public class UpdatePriorityQueue {

	public static class CompareTreeNode implements Comparator<TreeNode> {
		public int compare (TreeNode a, TreeNode b) {
			if(a.val > b.val) return 1;
			else if(a.val == b.val) return 0;
			else return -1;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode a = new TreeNode(1);
		TreeNode b = new TreeNode(2);
		TreeNode c = new TreeNode(3);
		
		UpdatePriorityQueue test = new UpdatePriorityQueue();
		
		Comparator newCom = new CompareTreeNode();
		
		PriorityQueue<TreeNode> queue = new PriorityQueue<>(3, newCom);
		
		queue.add(a);
		queue.add(b);
		queue.add(c);
		
		while(!queue.isEmpty()) {
			System.out.println(queue.poll().val);
		}
		
		System.out.println("after change a to 4: ");
		
		//change a in next round
		queue.add(a);
		queue.add(b);
		queue.add(c);
		
		a.val = 4;
		
		queue.remove(a);
		queue.add(a);
		
		
		while(!queue.isEmpty()) {
			System.out.println(queue.poll().val);
		}
		
	}

}
