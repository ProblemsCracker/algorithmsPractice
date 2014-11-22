package algorithmsPractice;

public class quickSort {

	static void sort(int[] arr, int left, int right) {
		int index = partition(arr, left, right);
		if(left < index - 1) {
			sort(arr, left, index - 1);
		}
		if(index < right) {
			sort(arr, index, right);
		}
	}
	
	static int partition(int[] arr, int left, int right) {
		int pivot = arr[(left + right) / 2];
		while(left <= right) {
			while(arr[left] < pivot) left++;
			while(arr[right] > pivot) right--;
			if(left <= right) {
				int tmp = arr[left];
				arr[left] = arr[right];
				arr[right] = tmp;
				left ++;
				right --;
			}
		}
		return left;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = new int[]{5, 6};
		//sort(arr,0, arr.length - 1);
		
		System.out.println(arr);
		
	}

}
