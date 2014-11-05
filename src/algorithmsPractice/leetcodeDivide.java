package algorithmsPractice;

public class leetcodeDivide {

	public static int divide(int dividend, int divisor) {
        boolean isNeg = false;
        if(dividend < 0) isNeg = !isNeg;
        if(divisor < 0) isNeg = !isNeg;
        
        int a = Math.abs(dividend);
        int b = Math.abs(divisor);
        
        int result = 0;
        
        while(a >= b) {
            int c = b;
            int tmpRes = 1;
            
            while(a >= c) {
                c = c << 1;
                tmpRes = tmpRes << 1;
            }

            tmpRes = tmpRes >> 1;
            c = c >> 1;
            
            result += tmpRes;
            a -= c;
        }
        
        if(isNeg) return -1 * result;
        else return result;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(divide(-15, 16));
	}

}
