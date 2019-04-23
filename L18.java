package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class L18 {
	public List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> sub = new ArrayList<Integer>();
		
		HashSet<List<Integer>> set = new HashSet<List<Integer>>();
		int len = nums.length;
		Arrays.sort(nums);
		//i和j是表示第一个数和第二个数，确定第一二个数，然后寻找第3 4 个数
		for(int i = 0; i < len - 3; i ++) {
			for(int j = i + 1; j < len - 2; j ++) {
				int start = j + 1;
				int end = len - 1;
				while (start < end) {
					if(nums[i] + nums[j] + nums[start] + nums[end] == target) {
						sub.add(nums[i]);
						sub.add(nums[j]);
						sub.add(nums[start]);
						sub.add(nums[end]);
                        if(!set.contains(sub)) {
                        	set.add(sub);
                        	result.add(new ArrayList<Integer>(sub));
                        }
                        sub.clear();
                        start ++;
                        end --;
					}else if (target > nums[i] + nums[j] + nums[start] + nums[end]) {
						start ++;
					}else {
						end --;
					}
				}
			}
		}
		return result;
	}
}
