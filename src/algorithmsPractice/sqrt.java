package algorithmsPractice;

public class sqrt {

	public int calSqrt(int n) {
		int start = 0;
		int end = n;
		int mid = 0;
		int result = -1;
		while(Math.abs(mid * mid - n) > 0) {
			mid = (start + end) / 2;
			if(mid * mid == n) {
				result = mid;
				break;
			}
			if(mid * mid < n && (mid + 1) * (mid + 1) > n) {
				result = mid;
				break;
			}
			if(mid * mid < n) start = mid + 1;
			else end = mid - 1;
		}
		return result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//sqrt test = new sqrt();
		//System.out.println(test.calSqrt(1000));
		
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.MIN_VALUE);
		
	}

}
