package algorithmsPractice;

public class EnumClass {

	public enum NewEnum {
		low,
		middle,
		high
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NewEnum test = NewEnum.low;
		if(test == NewEnum.middle)
			System.out.println("it's middle");
		System.out.println(test);
		test = NewEnum.high;
		System.out.println(test);
		
		test = NewEnum.middle;
		if(test == NewEnum.middle)
			System.out.println("it's middle");
		
		for(NewEnum now : NewEnum.values())
			System.out.println(now);
		
	}

}
