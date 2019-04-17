package leetcode;

import java.util.ArrayList;
import java.util.List;

public class L442 {
	/*
	 * 方法1：根据题目要求：给的验证数组最多出现两次相同的数，或者出现一次某个数，要求不开辟空间，
	 * 时间复杂度是O(n).因为数组输入的特点 1<=sums[i]<=n,则可以把原数组当hash表用 ，
	 * 因为原数组是正数，标为负数表示出现过，如果遇到负数 就表示第二次出现，就可以找出所有出现过2次的数
	 */
    public List<Integer> findDuplicates(int[] nums) {
    	int length = nums.length;
        List<Integer> resultList = new ArrayList<Integer>();
        for(int i = 0; i < length; i ++) {
        	int val = Math.abs(nums[i]) - 1;
        	if(nums[val] > 0) {
        		nums[val] = -nums[val];
        	}else {
				resultList.add(Math.abs(nums[i]));
			}
        }
        return resultList;
    }
}
