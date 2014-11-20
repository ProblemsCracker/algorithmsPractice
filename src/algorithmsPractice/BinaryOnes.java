package algorithmsPractice;

public class BinaryOnes {

	public static boolean isPalindrome(int x) {
        int left = 1;
        int right = 1;
        
        if(x < 0) return false;
        
        while(x / left > 1) {
            left *= 10;
        }
        
        while(left > right) {
            int leftDigit = (x / left) % 10;
            int rightDigit = (x / right) % 10;
            if(leftDigit != rightDigit) return false;
            
            left /= 10;
            right *= 10;
        }
        
        return true;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 5;
		
		int result = 1000000001;
		
		System.out.println(result);
		
		System.out.println(isPalindrome(result));
		
	}

}
