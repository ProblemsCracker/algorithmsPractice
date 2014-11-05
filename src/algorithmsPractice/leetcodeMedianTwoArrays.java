package algorithmsPractice;

public class leetcodeMedianTwoArrays {

	public static double findMedianSortedArrays(int A[], int B[]) {
	       int m = A.length;
	       int n = B.length;
	       int total = m + n;
	       if(total % 2 == 1) return find_kth(A, 0, m, B, 0, n, total / 2 + 1);
	       else {
	           return (find_kth(A, 0, m, B, 0, n, total / 2) + 
	                find_kth(A, 0, m, B, 0, n, total / 2 + 1)) / 2.0;
	       }
	    }
	    
	 public static int find_kth(int[] A, int curA, int m, int[] B, int curB, int n, int k) {
	        
	        //curA & curB are ....
	        //m is search length of A, n is search length of B
	        
	        if(m > n) return find_kth(B, curB, n, A, curA, m, k);
	        if(m == 0) return B[curB + k - 1];
	        if(k == 1) return Math.min(A[curA], B[curB]);
	        
	        int ia = Math.min(k / 2, m), ib = k - ia;
	        
	        if(A[curA + ia - 1] < B[curB + ib - 1])
	            return find_kth(A, curA + ia, m - ia, B, curB, n, k - ia);
	            
	        else if(A[curA + ia - 1] > B[curB + ib - 1])
	            return find_kth(A, curA, m, B, curB + ib, n - ib, k - ib);
	            
	        else return A[curA + ia - 1];
	    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {1,2};
		int[] B = {1,2,3,4,5};
		System.out.println(findMedianSortedArrays(A, B));
	}

}
