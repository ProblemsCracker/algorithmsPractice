package algorithmsPractice;

public class Divide {

	public static int divide(int dividend, int divisor) {
        int result = 0;
        boolean negative = false;
        
        //corner cases check
        if(divisor == 1) return dividend;
                
        if(dividend == 0) return 0;
        if(divisor == 0) {
            if(negative) return Integer.MIN_VALUE;
            else return Integer.MAX_VALUE;
        }
        
        //convert to long to calculate
        long longDividend = (long)dividend;
        long longDivisor = (long)divisor;
        
        if(longDividend < 0) {
            negative = !negative;
            longDividend = -longDividend;
        }
        if(longDivisor < 0) {
            negative = !negative;
            longDivisor = -longDivisor;
        }
        
        System.out.println("longDividend: " + longDividend);
        System.out.println("longDivisor: " + longDivisor);
        System.out.println(negative);
        
        System.out.println(longDividend > longDivisor);
        
        while(longDividend > longDivisor) {
            long curResult = 1;
            long curValue = longDivisor;
            while(longDividend >= curValue) {
                curValue <<= 1;
                curResult <<= 1;
            }
            curValue >>= 1;
            curResult >>= 1;
            result += (int)curResult;
            System.out.println("result: " + result);
            longDividend -= curValue;
        }
        
        if(longDividend == longDivisor) result++;
        
        if(negative) {
        	System.out.println(result);
        	return -result;
        }
        return result;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(divide(-2147483648,2));
	}

}
