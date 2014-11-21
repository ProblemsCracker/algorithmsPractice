package algorithmsPractice;

public class InsertBits {

	public int insertBits(int N, int M, int start, int end) {
		//set N 0
		int length = start - end + 1;
		int setZero = (1 << length) - 1;
		setZero = (setZero << end);
		setZero = (~setZero);
		N &= setZero;
		
		//move M to position
		M = (M << end);
		
		//insert
		N |= M;
		
		return N;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N = 0b11111010001001;
		int M = 0b10011;
		//int a = Integer.parseInt("00000010", 2);
		InsertBits test = new InsertBits();
		int result = test.insertBits(N, M, 6, 2);
		System.out.println(Integer.toBinaryString(N));
		System.out.println(Integer.toBinaryString(result));
	}

}
