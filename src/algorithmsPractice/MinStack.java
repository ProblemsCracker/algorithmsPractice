package algorithmsPractice;

import java.util.Stack;
import java.util.HashMap;

public class MinStack {
	    //heap?
	    //hashmap?
	    //stack is first in last out
	    //top element may not be the the minimun one but the last push one
	    //use a real stack but maintain the minimun element or a
	    //use hashmap<index, min>; the min value equals or below index
	    
	    //private int capacity = 10001;
	    private Stack<Integer> stack = new Stack<>();
	    private int peek = -1;
	    private HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
	    
	    public void push(int x) {
	        stack.push(x);
	        peek++;
	        if(map.containsKey(peek - 1)) {
	            int prevMin = map.get(peek - 1);
	            map.put(peek, prevMin);
	            if(x < prevMin) {
	                map.put(peek, x);
	            }
	        }
	        else {
	            map.put(peek, x);
	        }
	    }

	    public void pop() {
	        if(peek == -1) return;
	        stack.pop();
	        map.remove(peek);
	        peek--;
	    }

	    public int top() {
	        if(!stack.isEmpty()) {
	            return stack.peek();
	        }
	        else return -1;
	    }

	    public int getMin() {
	        if(map.isEmpty()) return -1;
	        return map.get(peek);
	    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinStack test = new MinStack();
		test.push(-3);
		test.push(3);
		test.push(-5);
		test.push(2);
		test.push(1);
		test.push(-10);
		test.push(3);
		test.pop();
		//test.pop();
		//test.pop();
		System.out.println(test.getMin());
	}

}
