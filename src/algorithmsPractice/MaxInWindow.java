package algorithmsPractice;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MaxInWindow {

	static class IntComparator implements Comparator<Integer> {
		int[] array;
		public IntComparator(int[] array) {
			this.array = array;
		}
		
		public int compare(Integer a, Integer b) {
			if(array[a] > array[b]) return -1;
			else if(array[a] == array[b]) return 0;
			else return 1;
		}
	}
	
	static List<Integer> findMax(int[] array, int win) {
		List<Integer> result = new ArrayList<Integer>();
		
		Comparator newCom = new IntComparator(array);
		
		PriorityQueue<Integer> queue = new PriorityQueue<>(win, newCom);
		
		int i = 0;
		
		for(i = 0; i < win; i++) {
			queue.add(i);
		}
		
		result.add(array[queue.peek()]);
		
		while(i < array.length) {
			queue.remove(i - win);
			queue.add(i);
			result.add(array[queue.peek()]);
			i++;
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {-1, 1, 9, 8, 1, 3, 5};
		List<Integer> result = findMax(array, 3);
		
		for(Integer i : result) {
			System.out.println(i);
		}
		
	}

}
