package algorithmsPractice;

public class DoubleToBinary {

	String toBinary(Double num) {
		StringBuilder sb = new StringBuilder();
		
		sb.append("0.");
		
		while(sb.length() <= 32) {
			
			Double diff = num * 2 - 1;
			int curDigit = 0;
			
			if(diff >= 0) curDigit = 1;
			sb.append(curDigit);
			
			if(diff == 0) break;
			else if(diff > 0)
				num = diff;
			else num = num * 2;
		}
		
		return sb.toString();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DoubleToBinary test = new DoubleToBinary();
		System.out.println(test.toBinary(.5));
	}

}
