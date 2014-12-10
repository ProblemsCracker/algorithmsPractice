package algorithmsPractice;

public class RegexMatchingShortAnswer {

	/**
	 * '.' Matches any single character.
		'*' Matches zero or more of the preceding element.
		
		The matching should cover the entire input string (not partial).
		
		The function prototype should be:
		bool isMatch(const char *s, const char *p)
		
		Some examples:
		isMatch("aa","a") → false
		isMatch("aa","aa") → true
		isMatch("aaa","aa") → false
		isMatch("aa", "a*") → true
		isMatch("aa", ".*") → true
		isMatch("ab", ".*") → true
		isMatch("aab", "c*a*b") → true
	 * @param s
	 * @param p
	 * @return
	 */
	
	public boolean isMatch(String s, String p) {
        //http://harrifeng.github.io/algo/leetcode/regular-expression-matching.html
        //ambituity:
        //design algo: 1. single match; 2. next is *; using substring to gain next string
        //pseudo code: 
        //code
        //test
        
        if(p.length() == 0) return s.length() == 0;
        
        if(p.length() == 1) {
            if(s.length() == 1 && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.'))
                return true;
            else return false;
        }
        
        if(p.charAt(1) != '*') {
            if(s.length() > 0 && (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.'))
                return isMatch(s.substring(1), p.substring(1));
            else return false;
        }
        
        //p.charAt(1) == '*'
        while(s.length() > 0 && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.')) {
            if(isMatch(s, p.substring(2))) return true;
            s = s.substring(1);
        }
        return isMatch(s, p.substring(2));
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
