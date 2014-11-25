package algorithmsPractice;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SingleNumberiiMoSF {

	 static List<Integer> toTenary(int num) {
	        List<Integer> tmpList = new ArrayList<>();
	        int remainder = 0;
	        
	        while(num != 0) {
	            remainder = num % 3;
	            num /= 3;
	            tmpList.add(remainder);
	        }
	        
	        return tmpList;
	    }
	    
	    public static int singleNumber(int[] A) {
	        //several passes
	        //no sort(larger than o(n))
	        //no count(no extra memory)
	        //sum them up?
	        //bit manipulation
	        //even ones to zero, odd ones to one in xor
	        //naive: hashmap or arrays.sort
	        //bit operation: check each bit
	        //what if there is a negative integer
	        List<List<Integer>> toList = new ArrayList<>();
	        int numDigits = 0;
	        for(int num : A) {
	            toList.add(toTenary(num));
	            numDigits = Math.max(numDigits, toTenary(num).size());
	        }
	        
	        int[] sumArr = new int[numDigits];
	        
	        for(List<Integer> numList : toList) {
	            int index = 0;
	            Iterator<Integer> it = numList.iterator();
	            while(it.hasNext()) {
	                int thisDigit = it.next();
	                sumArr[index] += thisDigit;
	                index++;
	            }
	        }
	        
	        for(int i = 0; i < sumArr.length; i++) {
	            sumArr[i] %= 3;
	        }
	        
	        int returnValue = 0;
	        int base = 1;
	        
	        for(int i = 0; i < sumArr.length; i++) {
	            returnValue += base * sumArr[i];
	            base *= 3;
	        }
	        
	        return returnValue;
	        
	    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int[] A = {1,2,3,1,2,-1,3,3,2,1};
		//System.out.println(singleNumber(A));
		//System.out.println(Integer.toBinaryString(Integer.MIN_VALUE));
		//System.out.println(Integer.toBinaryString(Integer.MAX_VALUE));
		//System.out.println(Integer.toBinaryString(-1));
		
		String s = "";
		
		String[] sArr = s.split("e");
		System.out.println(sArr.length);
		for(String str : sArr) {
			System.out.println(str);
		}
		
	}

}
