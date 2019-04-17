package leetcode;

public class L414 {
	/*
	 * 找出第三大的数字
	 */
    public int thirdMax(int[] nums) {
        long max = Long.MIN_VALUE;
        long medium = Long.MIN_VALUE;
        long min = Long.MIN_VALUE;
        
        for(int i = 0; i < nums.length; i ++) {
        	if(nums[i] >= max) {
        		if(nums[i] == max)  //记住要过滤这个条件
        			continue;
        		min = medium;       
        		medium = max;
        		max = nums[i];
        	}else if (nums[i] >= medium) {
        		if(nums[i] == medium)
        			continue;
        		min = medium;
				medium = nums[i];
			}else if(nums[i] >= min){
				if(nums[i] == min)
					continue;
				min = nums[i];
			}
        }
       return (int) ((min == Long.MIN_VALUE || max == min) ? max : min);
    }
    
    public static void main(String[] args) {
		int [] nums = new int [] {1, 2, 5, 3, 5};
		System.out.println(new L414().thirdMax(nums));
	}
}
