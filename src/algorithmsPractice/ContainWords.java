package algorithmsPractice;

import java.util.ArrayList;
import java.util.List;

public class ContainWords {

	public static int numDistinct(String S, String T) {
        //dp
        if(S.length() < T.length()) return 0;
        
        //dfs?
        List<Integer> result = new ArrayList<>();
        dfs(0, S, 0, T, result);
        
        return result.size();
    }
    
    public static void dfs(int sIndex, String s, int tIndex, String t, List<Integer> result) {
        if(tIndex == t.length()) {
            result.add(1);
            return;
        }
        
        for(int i = sIndex; i <= s.length() - (t.length() - tIndex); i++) {
            if(s.charAt(i) == t.charAt(tIndex)) {
                dfs(i + 1, s, tIndex + 1, t, result);
            }
        }
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(numDistinct("rabbbit", "rabbit"));
	}

}
