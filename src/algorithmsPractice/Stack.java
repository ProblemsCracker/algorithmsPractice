package algorithmsPractice;

public class Stack {

	ListNode top;
	
	ListNode pop() {
		if(top != null) {
			ListNode item = new ListNode(top.val);
			top = top.next;
			return item;
		}
		else return null;
	}
	
	void push(ListNode item) {
		ListNode t = new ListNode(item.val);
		t.next = top;
		top = t;
	}
	
	ListNode peek() {
		return top;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
