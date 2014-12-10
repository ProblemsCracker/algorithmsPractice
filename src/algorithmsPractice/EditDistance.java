package algorithmsPractice;

/**
 * check if edit distance equals or less than 1
 * @author wenbolin
 *
 */
public class EditDistance {
	
	public static boolean check(String a, String b) {
		int ia = 0;
		int ib = 0;
		int diff = 0;
		
		if(Math.abs(a.length() - b.length()) >= 2) return false;
		
		while(ia < a.length() && ib < b.length()) {
			if(a.charAt(ia) == b.charAt(ib)) {
				ia++;
				ib++;
			}
			else if(a.length() == b.length()) {
				ia++;
				ib++;
				diff++;
			}
			else if(a.length() < b.length()) {
				ib++;
				diff++;
			}
			else {
				ia++;
				diff++;
			}
			
			if(diff > 1) return false;
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		System.out.println(check("abca", "bba"));
	}
}
