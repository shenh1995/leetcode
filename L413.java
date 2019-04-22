package leetcode;

public class L413 {
	/*
	 * 我们还可以用DP来做，定义一个一维dp数组，其中dp[i]表示，
	 * 到i位置为止的算数切片的个数，那么我们从第三个数字开始遍历，
	 * 如果当前数字和之前两个数字构成算数切片，那么我们更新dp[i]为dp[i-1]+1，
	 * 然后res累加上dp[i]的值即可：
	 */
	public int numberOfArithmeticSlices(int[] A) {
		int res = 0, cur = 0;
		for(int i = 2; i < A.length; i ++) {
			if(A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
				cur += 1;
				res += cur;
			}else {
				cur = 0;
			}
		}
		return res;
	}
}
