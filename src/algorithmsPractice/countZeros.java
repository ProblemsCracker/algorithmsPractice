package algorithmsPractice;

public class countZeros {

	int countZero(int n) {
		int numOf2 = 0;
		int numOf5 = 0;
		
		for(int i = 2; i <= n; i++) {
			numOf2 += count2(i);
			numOf5 += count5(i);
		}
		
		return Math.min(numOf2, numOf5);
	}
	
	int count2 (int n) {
		int result = 0;
		while(n % 2 == 0 && n != 0) {
			result ++;
			n /= 2;
		}
		return result;
	}
	
	int count5 (int n) {
		int result = 0;
		while(n % 5 == 0 && n != 0) {
			result ++;
			n /= 5;
		}
		return result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		countZeros test = new countZeros();
		System.out.println(test.countZero(100));
	}

}
