package algorithmsPractice;

public class priorityQueue {

	private int arrayLength;
	
	private int queueSize;
	
	private int[] array;
	
	priorityQueue() {
		queueSize = 0;
		this.arrayLength = 100;
		this.array = new int[arrayLength];
	}
	
	public boolean isEmpty() {
		if(queueSize == 0) return true;
		return false;
	}
	
	public int pop() {
		if(queueSize == 0) return Integer.MAX_VALUE;
		
		/*****************************/
		//put the bottom element to the top and move the bottom element down
		int result = array[0];
		array[0] = array[queueSize - 1];
		/*****************************/
		
		queueSize --;
		array[queueSize] = 0;
		int i = 0;
		while(i <= queueSize - 1) {
			int leftChild = i * 2 + 1;
			int rightChild = i * 2 + 2;
			
			if(leftChild <= queueSize - 1 
					&& rightChild <= queueSize - 1 
					&& array[i] > Math.min(array[leftChild], array[rightChild])) {
				if(array[leftChild] < array[rightChild]) {
					int tmp = array[i];
					array[i] = array[leftChild];
					array[leftChild] = tmp;
					i = leftChild;
				}
				else {
					int tmp = array[i];
					array[i] = array[rightChild];
					array[rightChild] = tmp;
					i = rightChild;
				}
			}
			
			else if(leftChild <= queueSize - 1 && array[i] > array[leftChild]) {
				int tmp = array[i];
				array[i] = array[leftChild];
				array[leftChild] = tmp;
				i = leftChild;
			}
			
			else break;
		}
		
		return result;
	} 
	
	public boolean push( int target ) {
		if(queueSize >= arrayLength) return false;
		array[queueSize++] = target;
		
		int i = queueSize - 1;
		
		while(i >= 0) {
			int mother = i % 2 == 0? i / 2 - 1: i / 2;
			
			if(mother >= 0 && array[mother] > array[i]) {
				int tmp = array[mother];
				array[mother] = array[i];
				array[i] = tmp;
				i = mother;
			}
			else break;
			
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		priorityQueue test = new priorityQueue();
		test.push(10);
		test.push(1000);
		test.push(7);
		test.push(10);
		test.push(333);
		while(!test.isEmpty()) {
			System.out.println(test.pop());
		}
	}

}
