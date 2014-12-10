package algorithmsPractice;

public class ProducerConsumer {

	class Monitor{
		int BufferSize;
		int itemCount;
		int[] data;
		
		public Monitor(int size) {
			this.BufferSize = size;
			data = new int[size];
		}
		
		public synchronized void add(int item) {
			while(itemCount == BufferSize) {
				try{
					wait();
				} 
				catch (InterruptedException e) {
				}
				
				//put item into buffer
				data[itemCount] = item;
				itemCount++;
				
				if(itemCount == 1) {
					notifyAll();
				}
			}
		}
		
		public synchronized int remove() {
			while(itemCount == 0) {
				try{
					wait();
				}
				catch (InterruptedException e) {
				}
			}
			
			itemCount--;
			
			if(itemCount == BufferSize - 1) {
				notifyAll();
			}
			
			return data[itemCount];
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
