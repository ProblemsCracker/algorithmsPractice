package algorithmsPractice;

import java.util.Comparator;
import java.util.PriorityQueue;

public class SortList {

	public class ListNodeComparator implements Comparator<ListNode> {
        public int compare(ListNode a, ListNode b) {
                if(a.val > b.val) return 1;
                else if(a.val < b.val) return -1;
                else return 0;
        }    
    }
    
    public ListNode sortList(ListNode head) {
        
        if(head == null || head.next == null) return head;
        
        ListNode newHead = new ListNode(-1);
        
        ListNode cur = head;
        
        int count = 0;
        
        //count number to create priorityqueue
        //O(n)
        while(cur != null) {
            cur = cur.next;
            count ++;
        }
        
        System.out.println("count: " + count);
        
        Comparator<ListNode> newCompar = new ListNodeComparator();
        
        PriorityQueue<ListNode> queue = new PriorityQueue<>(count, newCompar);
        
        cur = head;
        
        //n
        while(cur != null) {
        	cur.next = null;
            queue.add(cur);
            cur = cur.next;
        }
        
        ListNode pre = newHead;
        
        int countloop = 0;
        
        //nlogn
        while(!queue.isEmpty()) {
        	countloop ++;
        	//System.out.println(countloop);
            cur = queue.poll();
            pre.next = cur;
            pre = pre.next;
        }
        
        return newHead.next;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SortList test = new SortList();
		ListNode a = new ListNode(2);
		ListNode b = new ListNode(1);
		a.next = b;
		ListNode result = test.sortList(a);
		while(result != null) {
			System.out.println(result.val);
			result = result.next;
		}
	}

}
