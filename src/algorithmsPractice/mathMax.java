package algorithmsPractice;

public class mathMax {

	public static int flip(int bit) {
		return 1^bit;
	}
	
	public static int sign(int a) {
		//0x1 Is just a hex value of 1.
		return flip((a >> 31) & 0x1);
	}
	
	//float max(float a, float b) {
		//float c = a - b;
		
	//}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//test case 1: all positive numbers
		StringBuilder sb = new StringBuilder();
		sb.append("012345678");
		sb.delete(3, 4);
		System.out.println(sb.toString());
		//String[] a = new String[2];
		
		
		String ab = "1.2.....";
		
		String[] abc  = ab.split("\\.");
		
		System.out.println(abc.length);
		
	}

}
