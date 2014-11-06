package algorithmsPractice;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class WordBreak {
	public static boolean wordBreak(String s, Set<String> dict) {
        //DFS + HashMap
        //learn iterator needs to specify type
        int minLength = Integer.MAX_VALUE;
        int maxLength = Integer.MIN_VALUE;
        
        if(dict.isEmpty()) return false;
        
        for(Iterator<String> it = dict.iterator(); it.hasNext(); ) {
            String curStr = it.next();
            minLength = Math.min(curStr.length(), minLength);
            maxLength = Math.max(curStr.length(), maxLength);
        }
        
        return dfs(s, dict, minLength, maxLength);
    }
    
    public static boolean dfs(String s, Set<String> dict, int minLength, int maxLength) {
        if(s.length() == 0) return true;
        
        for(int i = minLength; i <= Math.min(maxLength, s.length()); i ++) {
            String curStr = s.substring(0, i);
            if(dict.contains(curStr)) {
                
                if(dfs(s.substring(i), dict, minLength, maxLength))
                    return true;
                    
            }
        }
        
        return false;
    }
    
    public static void main(String[] args) {
    	String s = "leetcode";
    	Set<String> dict = new HashSet<String>();
    	
    	dict.add("leet");
    	dict.add("coe");
    	
    	System.out.println(wordBreak(s, dict));
    }
}
