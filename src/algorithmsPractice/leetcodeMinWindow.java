package algorithmsPractice;

import java.util.HashMap;

public class leetcodeMinWindow {
	
	public static String minWindow(String S, String T) {
        if(S.length() < T.length()) return "";
        
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        
        char[] arrT = T.toCharArray();
        
        for(char c : arrT) {
            if(map.containsKey(c)) {
                int times = map.get(c);
                map.put(c, times + 1);
            }
            else map.put(c, 1);
        }
        
        StringBuilder sbResult = new StringBuilder(S);
        int shortest = S.length();
        
        for(int i = 0; i <= S.length() - T.length(); i ++) {
            
            StringBuilder sbTmp = new StringBuilder();
            
            HashMap<Character, Integer> tmpMap = new HashMap<Character, Integer>(map);
            
            boolean found = false;
            
            if(map.containsKey(S.charAt(i)))
            	found = dfs(sbTmp, S, i, tmpMap, shortest);
            
            if(found && sbTmp.length() < sbResult.length()) {
                sbResult = sbTmp;
                shortest = sbTmp.length();
            }
        }
        
        return sbResult.toString();
    }
    
    public static boolean dfs(StringBuilder sbTmp, String s, int i, HashMap<Character, Integer> map, int shortest) {
        if(map.isEmpty()) {
            return true;
        }
        
        if(sbTmp.length() >= shortest || i >= s.length()) return false;
        
        char curC = s.charAt(i);
        
        sbTmp.append(curC);
        
        if(map.containsKey(curC)) {
            int times = map.get(curC);
            if(times == 1) map.remove(curC);
            else map.put(curC, times - 1);
        }
        
        return dfs(sbTmp, s, i + 1, map, shortest);
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "ADOBECODEBANC";
		String t = "ABC";
		String result = minWindow(s, t);
		System.out.println(result);
	}

}
