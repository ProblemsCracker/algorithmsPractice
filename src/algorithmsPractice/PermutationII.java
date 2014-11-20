package algorithmsPractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PermutationII {

	public static List<List<Integer>> permuteUnique(int[] num) {
        List<List<Integer>> result = new ArrayList<>();
        //dfs start from no duplicate
        //use set
        List<Integer> cur = new ArrayList<>();
        boolean[] used = new boolean[num.length];
        Arrays.sort(num);
        dfs(num, result, cur, used);
        return result;
    }
    
    public static void dfs(int[] num, List<List<Integer>> result, List<Integer> cur, boolean[] used) {
        if(cur.size() == num.length) {
            result.add(new ArrayList<Integer>(cur));
            return;
        }
        
        if(cur.size() == num.length) return;
        
        Set<Integer> sameInt = new HashSet<Integer>();
        
        for(int k = 0; k < num.length; k++) {
            if(!used[k] && !sameInt.contains(num[k])) {
                used[k] = true;
                sameInt.add(num[k]);
                cur.add(num[k]);
                dfs(num, result, cur, used);
                cur.remove(cur.size() - 1);
                used[k] = false;
            }
        }
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num = {1,1,1,1,5};
		List<List<Integer>> result = permuteUnique(num);
		
		for(List<Integer> curList : result) {
			for(Integer i : curList) {
				System.out.print(i);
			}
			System.out.println();
		}
		
	}

}
