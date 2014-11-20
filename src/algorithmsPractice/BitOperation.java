package algorithmsPractice;

public class BitOperation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num = 8;//1000
		//int check = num | (1 << 2);//1100
		int check = 0;
		String s = "";
		int i = 5;
		int j = 1 << (i + 1);
		int k = j - 1;
		int l = ~k;
		System.out.println(Integer.toBinaryString(l));
	}

}
