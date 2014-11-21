package algorithmsPractice;

public class RemoveElement {

	 public static int removeElement(int[] A, int elem) {
	        //switch all non target element to the front of index
	        int end = A.length - 1;
	        
	        if(A.length == 0) return 0;
	        
	        int start = 0;
	        
	        int count = 0;
	        
	        while(end > start) {
	            //when end meet non elem
	            while(A[end] == elem && end > start) {
	                end--;
	                count++;
	            }
	            
	            //when start meet elem
	            while(A[start] != elem && start < end) {
	                start ++;
	            }
	            
	            //switch start and end
	            if(start < end) {
	                int tmp = A[start];
	                A[start] = A[end];
	                A[end] = tmp;
	            }
	        }
	    
	        return A.length - count;
	    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {2,3,3,3,3};
		int result = removeElement(A, 3);
		System.out.println(result);
	}

}
