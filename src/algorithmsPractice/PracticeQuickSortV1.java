package algorithmsPractice;

public class PracticeQuickSortV1 {

	static int partition(int[] num, int start, int end) {
		int mid = (start + end) / 2;
		int target = num[mid];
		while(start <= end) {//!!!!!!!
			while(num[start] < target) {
				start++;
			}
			while(num[end] > target) {
				end--;
			}
			if(start <= end) {//!!!!!!!
				int tmp = num[start];
				num[start] = num[end];
				num[end] = tmp;
				//remember following two lines
				start++;
				end--;
			}
		}
		return start;
	} 
	
	static void quickSort(int[] num, int start, int end) {
		if(start >= end) return;
		int index = partition(num, start, end);
		if(start < index - 1)//!!!!!
			quickSort(num, start, index - 1);
		if(index < end)//!!!!!!!
			quickSort(num, index, end);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] test = {4,5,2,3,1,2,5,4,3,3,2,2,7,1};
		quickSort(test, 0, test.length - 1);
		for(int i : test)
			System.out.println(i);
	}

}
