package algorithmsPractice;

public class Queue {

	ListNode first, last;
	
	void enqueue(ListNode item) {
		if(first == null) {
			last = new ListNode(item.val);
			first = last;
		} else {
			last.next = new ListNode(item.val);
			last = last.next;
		}
	}
	
	ListNode dequeue() {
		if(first != null) {
			ListNode item = new ListNode(first.val);
			first = first.next;
			return item;
		}
		return null;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
