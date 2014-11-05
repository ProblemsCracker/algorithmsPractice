package algorithmsPractice;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueueTest {
	
	//goal of testing: change of compare function will change the top of heap (min or max)
	
	public class IntComparator implements Comparator<Integer> {
		public int compare(Integer a, Integer b) {
			if(a > b) return -1;
			else if(a < b) return 1;
			else return 0;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PriorityQueueTest test = new PriorityQueueTest();
		Comparator newCom = test.new IntComparator(); 
		PriorityQueue<Integer> queue = new PriorityQueue<>(10, newCom);
		queue.add(1);
		queue.add(2);
		queue.add(3);
		while(!queue.isEmpty()) {
			System.out.println(queue.poll());
		}
	}

}
