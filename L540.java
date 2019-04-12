package leetcode;


public class L540 {
	//这个题目用异或就能解决
    public int singleNonDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) {
			return 0;
		}
        
        int result = nums[0];
        for(int i = 1; i < nums.length; i ++) {
        	result ^= nums[i];
        }
        
        return result;
    }
}
