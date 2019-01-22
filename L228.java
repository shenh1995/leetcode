package Algorithm;

import java.util.ArrayList;
import java.util.List;

public class L228 {
	
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<String>();
        
        if(nums.length == 0 || nums == null) {
        	return result;
        }
        
        int start = 0, end = 0;
        while(end < nums.length) {
        	//这个表示还可以往前
        	if(end + 1 < nums.length && nums[end + 1] == nums[end] + 1) {
        		end ++;
        	}else {
        		//意思是后面的不连续了，接着判断这串连续数字里面是不是只有一个数字
				if(start == end) {
					result.add(Integer.toString(nums[start]));
				}else {
					String str = nums[start] + "->" + nums[end];
					result.add(str);
				}
				end++;
				start = end;
			}
        }
        return result;
    }
}
