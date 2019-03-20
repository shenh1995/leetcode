package Algorithm;

public class L396 {

	public int maxRotatrFunction(int [] A) {
		if (A == null || A.length == 0) {
			return 0;
		}
		if(A.length == 1)
			return 0;
		
		int max = Integer.MIN_VALUE;
		//找规律
		for(int i = 0; i < A.length; i ++) {
			int sum = 0;
			for(int j = A.length - i, k = 0; j < 2 * A.length - i; j ++, k ++) {
				sum += A[j % A.length] * k;
			}
			System.out.println(sum);
			if(sum > max) 
				max = sum;
		}
		return max;
	}
	
	public static void main(String[] args) {
		int [] A = new int [] {4, 3, 2, 6};
		System.out.println(new L396().maxRotatrFunction(A));
	}
}
