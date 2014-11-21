package algorithmsPractice;

public class NumOf1InBin {

	int count1(int num) {
		int count = 0;
		while(num > 0) {
			if((num & 1) == 1)
				count ++;
			num = num >> 1;
		}
		return count;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NumOf1InBin test = new NumOf1InBin();
		System.out.println(test.count1(0b01111000100100));
	}

}
