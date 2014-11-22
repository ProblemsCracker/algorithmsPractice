package algorithmsPractice;

public class PracticeKmpV1 {

	static int[] findNext(String p) {
		int[] next = new int[p.length()];
		
		next[0] = -1;
		int i = 0;//suffix
		int j = -1;//prefix
		
		while(i < p.length() - 1) {
			if(j == -1 || p.charAt(i) == p.charAt(j)) {
				i++;
				j++;
				next[i] = j;
			}
			else 
				j = next[j];
		}
		
		return next;
	}
	
	static int match(String s, String p, int[] next) {
		int i = 0;
		int j = 0;
		while(i < s.length() && j < p.length()) {
			if(j == -1 || s.charAt(i) == p.charAt(j)) {
				i++;
				j++;
			}
			else 
				j = next[j];
		}
		
		if(j == p.length()) return i - p.length();
		else return -1;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "asdfsdsssfasdfasdfas";
		String p = "fasd";
		int[] next = findNext(p);
		int result = match(s, p, next);
		System.out.println(result);
	}

}
