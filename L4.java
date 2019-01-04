package Algorithm;

public class L4 {
	public static double findMedianSortedArrays(int A[], int B[]) {
		 int m = A.length;
		 int n = B.length;
		 int total = m + n;
		 if(total % 2 != 0) {
			 return (double) findKth(A, 0, m - 1, B, 0, n - 1, total / 2 + 1);
		 }else {
			double x = findKth(A, 0, m - 1, B, 0, n - 1, total / 2);
			double y = findKth(A, 0, m - 1, B, 0, n - 1, total / 2 + 1);
			return (x + y) / 2;
		}
	}
	
	public static int findKth(int[] A, int astart, int aend, int[] B, int bstart, int bend, int k) {
		int m = aend - astart + 1;
		int n = bend - bstart + 1;
		
		if(m > n) 
			return findKth(B, bstart, bend, A, astart, aend, k);
		if(m == 0)
			return B[k - 1]; //这里的意思是A中所有元素都要比B[k - 1]要小
		if(k == 1)
			return Math.min(A[astart], B[bstart]); //代表这如果total为偶数，那么k=1时返回小的那个数字
		
		int partA = Math.min(k / 2, m);
		int partB = k - partA;
		if(A[astart + partA - 1] < B[bstart + partB - 1]) {
			return findKth(A, astart + partA, aend, B, bstart, bend, k - partA);
		}else if (A[astart + partA - 1] > B[bstart + partB - 1]) {
			return findKth(A, astart, aend, B, bstart + partB, bend, k - partB);
		}else {
			return A[astart + partA - 1];
		}
	}
}
