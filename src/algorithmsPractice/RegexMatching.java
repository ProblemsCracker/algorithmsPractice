package algorithmsPractice;

import java.util.ArrayList;

public class RegexMatching {

	public static boolean isMatch(String s, String p) {
        ArrayList<String> patterns = new ArrayList<>();
        getPatterns(p, patterns);
        return isMatch(s, patterns, 0, 0);
    }
    
    public static boolean isMatch(String s, ArrayList<String> patterns, int sIndex, int pIndex) {
        if(sIndex >= s.length() && pIndex >= patterns.size()) {
            return true;
        }
        
        if(pIndex >= patterns.size()) return false;
        
        String curPattern = patterns.get(pIndex);
        
        //a
        if(curPattern.length() == 1 && !curPattern.equals(".")) {
            if(curPattern.charAt(0) == s.charAt(sIndex))
                return isMatch(s, patterns, sIndex + 1, pIndex + 1);
            else return false;
        }
        
        //.
        if(curPattern.length() == 1 && curPattern.equals(".")) {
            return isMatch(s, patterns, sIndex + 1, pIndex + 1);
        }
        
        //a*
        if(curPattern.length() == 2 && curPattern.charAt(0) != '.') {
            int numOfSameLetter = 0;
            int tmpIndex = sIndex;
            
            while(tmpIndex < s.length() && s.charAt(tmpIndex) == curPattern.charAt(0)) {
                numOfSameLetter ++;
                tmpIndex ++;
            }
            
            for(int i = 0; i <= numOfSameLetter; i++) {
                if(isMatch(s, patterns, sIndex + i, pIndex + 1))
                    return true;
            }
        }
        
        //.*
        else {
            for(; sIndex <= s.length(); sIndex ++) {
                if(isMatch(s, patterns, sIndex, pIndex + 1))
                    return true;
            }
        } 
        
        return false;
    }
    
    public static void getPatterns(String p, ArrayList<String> patterns) {
        int index = 0;
        while(index < p.length()) {
            if(index >= p.length() - 1 || p.charAt(index + 1) != '*') {
                patterns.add("" + p.charAt(index));
                index ++;
            }
            else{
                patterns.add("" + p.charAt(index) + p.charAt(index + 1));
                index += 2;
            }
        }
        for(String s : patterns)
        	System.out.println(s);
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "a";
		String p = "ab*";
		System.out.println(isMatch(s, p));
	}

}
