package algorithmsPractice;

public class RemoveDup {

	public static int removeDuplicates(int[] A) {
        if(A.length <= 2) return A.length;
        
        int pre = A[0];
        int targetIndex = 0;
        
        int count = 0;
        int subCount = 1;
        //1,1,2(1),2,2,2,2,2,3,4,5
        
        //1,1,2,2,3
        
        //condition targetIndex is always one element or two element ahead of pre
        //i is always one or more elements ahead of targetIndex
        for(int i = 1; i < A.length; i++) {
            int curNum = A[i];
            if(curNum == pre) {
                subCount++;
                if(subCount == 2) {//two element ahead
                	A[++targetIndex] = curNum;
                }
                else {
                    count++;
                }
            }
            else {
                subCount = 1;
                pre = curNum;
                if(targetIndex < A.length) {
                    A[++targetIndex] = curNum;
                }
                else break;
            }
        }
        
        return A.length - count;
        
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {1,2,3,3};
		int result = removeDuplicates(A);
		System.out.println(result);
		for(int i : A) {
			System.out.println(i);
		}
	}

}
