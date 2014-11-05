package algorithmsPractice;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

public class leetcodeSubstringOfConcatenationOfAllWords2 {

	public static ArrayList<Integer> findSubstring(String S, String[] L) {
       ArrayList<Integer> result = new ArrayList<Integer>();
        
        if(L.length == 0) return result;
        
        int wordLength = L[0].length();
        int totalLength = L.length * wordLength;
        
        if(S.length() < totalLength) return result;
        
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        
        for(int i = 0; i < L.length; i++) {
            if(map.containsKey(L[i])) {
                int times = map.get(L[i]);
                map.put(L[i], times + 1);
            }
            else map.put(L[i], 1);
        }
        
        for(int i = 0; i <= S.length() - totalLength; i++) {
            if( dfs(S.substring(i, i + totalLength), L, map, wordLength) ) 
                result.add(i);
        }
        
        return result;
    }
    
    public static boolean dfs(String s, String[] L, HashMap<String, Integer> map, int wordLength) {
        if(s.length() == 0) return true;
        
        boolean result = false;
        
        String word1 = s.substring(0, wordLength);
        
        if(map.containsKey(word1)) {
            
            int times = map.get(word1);
            if(times == 1) map.remove(word1);
            else map.put(word1, times - 1);
            
            result = dfs(s.substring(wordLength), L, map, wordLength);
            
            map.put(word1, times);
        }
        
        return result;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] dict = {"bar", "foo"};
		String s = "barfoothefoobarman";
		ArrayList<Integer> al = findSubstring(s, dict);
		for(Integer i : al) {
			System.out.println(i);
			List<String> list = new ArrayList<>();
		}
	}

}
