package algorithmsPractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FourSum {

	public static List<List<Integer>> fourSum(int[] num, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        if(num.length < 4) return result;
        
        Arrays.sort(num);
        
        Set<List<Integer>> set = new HashSet<List<Integer>>();
        
        for(int i = 1; i < num.length; i++) {
            for(int j = i + 1; j < num.length - 1; j++) {
                int leftI = i - 1;
                int rightJ = j + 1;
                while(leftI >= 0 && rightJ < num.length) {
                    int tmpSum = num[leftI] + num[i] + num[j] + num[rightJ];
                    List<Integer> curList = new ArrayList<Integer>();
                    curList.add(num[leftI]);
                    curList.add(num[i]);
                    curList.add(num[j]);
                    curList.add(num[rightJ]);
                    if(tmpSum == target) {
                        if(!set.contains(curList)) {
                            result.add(curList);
                            set.add(curList);
                        }
                        leftI--;
                        rightJ++;
                    }
                    else if(tmpSum > target) leftI--;
                    else rightJ++;
                }
            }
        }
        
        return result;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] test = {1, 0, -1, 0, -2, 2};
		List<List<Integer>> result = fourSum(test, 0);
		for(List<Integer> curList : result) {
			for(int i : curList) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}

}
