package algorithmsPractice;

public class WildcardMatching {

	/*
	 * '?' Matches any single character.
	'*' Matches any sequence of characters (including the empty sequence).
	
	The matching should cover the entire input string (not partial).
	
	The function prototype should be:
	bool isMatch(const char *s, const char *p)
	
	Some examples:
	isMatch("aa","a") → false
	isMatch("aa","aa") → true
	isMatch("aaa","aa") → false
	isMatch("aa", "*") → true
	isMatch("aa", "a*") → true
	isMatch("ab", "?*") → true
	isMatch("aab", "c*a*b") → false
	 */
	
	public boolean isMatch(String s, String p) {
        //ambiguity
        //design algo
        //pseudo code
        //code
        //test: extreme cases!!
        
        if(p.length() == 0) return s.length() == 0;
        
        int sPointer = 0;
        int pPointer = 0;
        int star = -1;
        int mark = -1;
        
        while(sPointer < s.length()) {
            //!!!
            if(pPointer < p.length() && (p.charAt(pPointer) == '?' || s.charAt(sPointer) == p.charAt(pPointer))) {
                sPointer++;
                pPointer++;
            }
            //!!!
            else if(pPointer < p.length() && p.charAt(pPointer) == '*') {
                star = pPointer ++;
                mark = sPointer ;
            }
            //pPointer out of bound or doesn't match single char, need star to save life!!
            else if(star != -1) {
                pPointer = star + 1;
                sPointer = ++mark;
            }
            else return false;
        }
        
        //run out of s but p stil have tail
        while(pPointer < p.length() && p.charAt(pPointer) == '*') pPointer ++;
        return pPointer == p.length();
        
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
