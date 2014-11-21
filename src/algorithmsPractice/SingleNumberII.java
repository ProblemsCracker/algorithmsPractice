package algorithmsPractice;

public class SingleNumberII {

	public static int find(int[] A) {
		int result = 0;
		for(int j = 0; j < 32; j++) {
			int curBitNum = 0;
			for(int i = 0; i < A.length; i++) {
				curBitNum += ((A[i] >> j) & 1); 
			}
			if(curBitNum % 3 == 1) {
				result += (1 << j);
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {1,2,2,4,4,5,1,2,1,4};
		int result = find(A);
		System.out.println(result);
	}

}
