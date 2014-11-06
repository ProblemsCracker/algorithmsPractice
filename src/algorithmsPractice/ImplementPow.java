package algorithmsPractice;

public class ImplementPow {

	public double pow(double a, int expo) {
		if(expo == 0) return 1;
		if(expo < 0) {
			expo = -expo;
			return 1./pow(a, expo);
		}
		
		double half = pow(a, expo / 2);
		
		if(expo % 2 == 0) {
			return half * half;
		}
		else return half * half * a;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ImplementPow test = new ImplementPow();
		double result = test.pow(3, -3);
		System.out.println(result);
		System.out.println((double)1/27);
	}

}
