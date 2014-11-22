package algorithmsPractice;

public class ReverseInt {

	public static int reverse(int x) {
        boolean negative = false;
        
        if(x < 0) negative = true;
        x = Math.abs(x);
        //what if the input is a floating number
        int result = 0;
        while(x > 0) {
            int curDigit = x % 10;
            if(result > Integer.MAX_VALUE / 10) return 0;
            result = result * 10 + curDigit;
            x /= 10;
        }
        
        if(negative) return -result;
        return result;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(reverse(1534236469));
		System.out.println(Integer.MAX_VALUE);
	}

}
