package leetcode;

public class L80 {
	/*
	 * 设置两个指针，i和j，如果有三个相等，则j一直往前，最后赋值
	 */
    public int removeDuplicates(int[] nums) {
      if(nums == null)
    	  return 0;
      if(nums.length <= 2)
    	  return nums.length;
      int i = 1;
      int j = 2;
      while (j < nums.length) {
		if(nums[j] == nums[i] && nums[j] == nums[i - 1]) {
			j ++;
		}else {
			i ++;
			nums[i] = nums[j];
			j ++;
		}
	}
      return i + 1;
    }
}
