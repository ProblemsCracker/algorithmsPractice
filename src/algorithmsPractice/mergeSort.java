package algorithmsPractice;

public class mergeSort {

	void mergesort(int[] array) {
		int[] helper = new int[array.length];
		mergesort(array, helper, 0, array.length - 1);
	}
	
	void mergesort(int[] array, int[] helper, int low, int high) {
		if(low < high) {
			int mid = (low + high) / 2;
			mergesort(array, helper, low, mid);
			mergesort(array, helper, mid + 1, high);
			merge(array, helper, low, mid, high);
		}
	}
	
	void merge(int[] array, int[] helper, int low, int middle, int high) {
		for(int i = low; i <= high; i++) helper[i] = array[i];
		
		int helperLeft = low;
		int helperRight = middle + 1;
		int current = low;
		
		while(helperLeft <= middle && helperRight <= high) {
			if(helper[helperLeft] <= helper[helperRight]) {
				array[current] = helper[helperLeft];
				helperLeft ++;
			} else {
				array[current] = helper[helperRight];
				helperRight ++;
			}
			current ++;
		}
		
		int remaining = middle - helperLeft;
		
		for(int i = 0; i <= remaining; i++) {
			array[current + i] = helper[helperLeft + i];
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {2,1,4,3,1,3,-5};
		mergeSort test = new mergeSort();
		test.mergesort(array);
		for(int i : array) System.out.println(i);
	}

}
