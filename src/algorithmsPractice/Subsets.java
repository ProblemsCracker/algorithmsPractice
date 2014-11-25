package algorithmsPractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Subsets {

	class NewCom implements Comparator<String> {
        public int compare(String a, String b) {
            return -a.compareTo(b);
        }
    }
    
    public List<List<Integer>> subsets(Integer[] S) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        Comparator newCom = new NewCom();
        
        Arrays.sort(S, newCom);
        
        result.add(new ArrayList<Integer>());
        
        for(int i = 0; i < S.length; i++) {
            List<List<Integer>> cur = new ArrayList<List<Integer>>(result);
            for(List<Integer> curList : cur) {
                curList.add(S[i]);
            }
            result.addAll(cur);
        }
        
        return result;
        
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[] S = {"dbc", "gbc", "vbc"};
		Subsets test = new Subsets();
		Comparator newCom = test.new NewCom();
		Arrays.sort(S, newCom);
		for(String s : S)
			System.out.println(s);
		Integer i = 1;
		System.out.println(i.compareTo(4));
	}

}
