package algorithmsPractice;

public class ShaoFengMoFindMax {

	public static int findMax(int[] arr) {
		int result = 0;
		
		if(arr.length == 1) {
			return arr[0];
		}
		
		int start = 0;
		int end = arr.length - 1;
		
		while(true) {
			int mid = start + (end - start) / 2;
			
			if(mid == 0 && arr[mid] > arr[mid + 1]) {
				return arr[mid];
			}
			else if(mid == arr.length - 1 && arr[mid] > arr[mid - 1]) {
				return arr[mid];
			}
			else if(arr[mid - 1] < arr[mid] && arr[mid] > arr[mid + 1]) {
				return arr[mid];
			}
			
			else if(Math.abs(start - end) <= 1 && arr[start] == arr[end]) {
				return arr[start];
			}
			
			else if(mid == 0 || mid < arr.length - 1 && arr[mid] <= arr[mid + 1]) {//one bug here
				int runner = mid;
				while(runner < arr.length && arr[runner] == arr[runner + 1]) {//one bug here
					runner++;
				}
				if(runner >= arr.length) {
					return arr[0];
				}
				else {
					start = runner + 1;
				}
			}
			
			else {
				int runner = mid;
				while(runner >= 0 && arr[runner] == arr[runner - 1]) {//one bug here
					runner--;
				}
				if(runner < 0) {
					return arr[0];
				}
				else {
					end = runner - 1;
				}
			}
			
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//case 1
		//int[] A = {1,2,3,4,5,3,2,0,-1};
		
		//case 2
		//int[] A = {5,4,3,1};
		
		//case 3
		//int[] A = {1,2,3,1};
		
		//case 4
		//int[] A = {-1};
		
		//case 5
		//int[] A = {1,1,2,2,1,1};
		
		//case 6
		int[] A = {1,1,2,2,3,3,3,4,4,4,5,5,5,2,2,2,1};
		
		System.out.println(findMax(A));
		
	}

}
