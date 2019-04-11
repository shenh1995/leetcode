package Algorithm;

import java.util.Arrays;

public class L462 {
	/*
	 * 为了移动的次数最小，显然应该是中位数，其实无论数组的位数是奇数还是偶数，移动的次数都是一样的。
	 */
	public int minMoves2(int [] nums) {
		if(nums == null || nums.length == 0) {
			return 0;
		}
		Arrays.sort(nums);
		int median = nums[nums.length / 2];
		int sum = 0;
		for(int i = 0; i < nums.length; i ++) {
			sum += Math.abs(nums[i] - median);
		}
		return sum;
	}

}
