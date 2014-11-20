package algorithmsPractice;

public class myKmpPractice {

	public static int[] buildNext(String p) {
		int[] next = new int[p.length()];
		
		int k = -1;
		int j = 0;
		
		next[0] = -1;
		
		int n = p.length();
		
		while(j < n - 1) {
			//k is prefix, j is suffix
			if(k == -1 || p.charAt(k) == p.charAt(j)) {
				k++;
				j++;
				next[j] = k;
			}
			else {
				k = next[k];
			}
		}
		
		return next;
		
	}
	
	public static int kmp(String s, String p, int[] next) {
		int i = 0;
		int j = 0;
		
		while(i < s.length() && j < p.length()) {
			if(j == -1 || s.charAt(i) == p.charAt(j)) {
				i++;
				j++;
			}
			else{
				j = next[j];
			}
		}
		
		return (j == p.length()) ? (i - p.length()) : -1;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "abcefgggefgsddeefgggefgsdefffg";
		String p = "efgggefgsdeff";
		int[] next = buildNext(p);
		System.out.println(kmp(s, p, next));
		System.out.println(s.indexOf(p));
	}

}
