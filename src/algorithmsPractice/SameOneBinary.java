package algorithmsPractice;

public class SameOneBinary {

	static int findBigger(int n) {
		int findTargetPos = 0;
		int tmp = n;
		
		while((tmp & 1) == 0 && tmp != 0) {
			tmp = tmp >> 1;
			findTargetPos ++;
		} 
		
		int countRightOne = 0;
		
		while((tmp & 1) == 1) {
			tmp = tmp >> 1;
			findTargetPos ++;
			countRightOne ++;
		}
		
		int addOne = 1 << findTargetPos;
		
		//flip 0 in target position to one
		n |= addOne;
		
		//clear right ones
		addOne = ~0;
		addOne <<= findTargetPos;
		n &= addOne;
		
		//add one back
		countRightOne --;
		addOne = (1 << countRightOne) - 1;
		
		n |= addOne;
		
		return n;
	}
	
	static int findSmaller(int n) {
		int tmp = n;
		int findPos = 0;
		int countOne = 0;
		
		//find ones
		while((tmp & 1) == 1 && tmp != 0) {
			tmp >>= 1;
			findPos ++;
			countOne++;
		}
		
		//find 0s
		while((tmp & 1) == 0) {
			tmp >>= 1;
			findPos ++;
		}
		
		int set0 = ~(1 << findPos);
		
		//set position to 0
		n &= set0;
		
		//clear right ones
		set0 = (~0) << findPos;
		n &= set0;
		
		//set right 1s
		int set1 = (1 << (countOne + 1)) - 1;
		set1 <<= findPos - (countOne + 1);
		
		n |= set1;
		
		return n;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int result = findBigger(0b11011);
		System.out.println(Integer.toBinaryString(result));
		//System.out.println(1 ^ 1);
		
		int result1 = findSmaller(0b10011110000011);
		System.out.println(Integer.toBinaryString(result1));
	}

}
