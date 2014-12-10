package algorithmsPractice;

import java.util.Map;
import java.util.HashMap;

public class MinimunSteps {

	public static int minSteps(int m, int n) {
		if(m == n) return Integer.MAX_VALUE;
		
		int steps = 0;
		
		while(m > 1 || n > 1) {
			int preM = 0;
			int preN = 0;
			if(m > n) {//m = preM + preN, n = preN
				preM = m - n;
				preN = n;
			}
			else {//m = preM, n = preM + preN;
				preM = m;
				preN = n - m;
			}
			m = preM;
			n = preN;
			steps++;
		}
		
		return steps;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(minSteps(4, 3));
		
		Map<Integer, Integer> map = new HashMap<>();
		
		System.out.println(map.get(1));
		
	}

}
