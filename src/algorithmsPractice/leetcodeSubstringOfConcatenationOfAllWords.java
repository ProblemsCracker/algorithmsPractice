package algorithmsPractice;

import java.util.ArrayList;

public class leetcodeSubstringOfConcatenationOfAllWords {

	public static ArrayList<Integer> findSubstring(String S, String[] L) {
		ArrayList<Integer> result = new ArrayList<Integer>();
        
        if(L.length == 0) return result;
        
        int wordLength = L[0].length();
        int totalLength = L.length * wordLength;
        
        if(S.length() < totalLength) return result;
        
        for(int i = 0; i <= S.length() - totalLength; i++) {
            boolean[] visited = new boolean[L.length];
            if( dfs(S.substring(i, i + totalLength), L, visited, wordLength) ) 
                result.add(i);
        }
        
        return result;
    }
    
    public static boolean dfs(String s, String[] L, boolean[] visited, int wordLength) {
        if(s.length() == 0) return true;
        
        boolean result = false;
        
        for(int i = 0; i < L.length; i++) {
            if(!visited[i]) {
                String word1 = s.substring(0, wordLength);
                String word2 = L[i];
                if(word1.equals(word2)) {
                    visited[i] = true;
                    result |= dfs(s.substring(wordLength), L, visited, wordLength);
                    if(result == true) break;
                    visited[i] = false;
                }
            }
        }
        
        return result;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] dict = {"bar", "foo", "sss"};
		String s = "adsfasdfasdfbarasdffoothefoobarman";
		ArrayList<Integer> al = findSubstring(s, dict);
		for(Integer i : al) {
			System.out.println(i);
		}
	}

}
