package algorithmsPractice;

public class PracticeQuickSortV1 {

	static int partition(int[] num, int target, int start, int end) {
		while(start < end) {
			while(start <= end && num[start] < target) {
				start++;
			}
			while(end >= start && num[end] > target) {
				end--;
			}
			if(start < end) {
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
		int mid = (start + end) / 2;
		int index = partition(num, num[mid], start, end);
		if(start < index)
			quickSort(num, start, index);
		if(index < end)
			quickSort(num, index + 1, end);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] test = {4,5,2,3,1,2,5,4,3,3,2,2,7,1};
		quickSort(test, 0, test.length - 1);
		for(int i : test)
			System.out.println(i);
	}

}
