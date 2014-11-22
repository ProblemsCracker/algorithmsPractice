package algorithmsPractice;

public class PracticeMergeSortV1 {

	public static void mergeSort(int[] num, int[] helper, int low, int high) {
		if(low == high) return;
		int mid = (low + high) / 2;
		mergeSort(num, helper, low, mid);
		mergeSort(num, helper, mid + 1, high);
		merge(num, helper, low, mid, high);
	}
	
	public static void merge(int[] num, int[] helper, int low, int middle, int high) {
		int left = low;
		int right = middle + 1;
		
		for(int i = low; i <= high; i++)
			helper[i] = num[i];
		
		int i = low;
		while(left <= middle && right <= high) {
			if(helper[left] > helper[right]) {
				num[i++] = helper[right++];
			}
			else {
				num[i++] = helper[left++];
			}
		}
		
		while(left <= middle) {
			num[i++] = helper[left++];
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] test = {4,5,2,3,1,2,5,4,3,3,2,2,7,1};
		int[] helper = new int[test.length];
		mergeSort(test, helper, 0, test.length - 1);
		for(int i : test)
			System.out.println(i);
	}

}
