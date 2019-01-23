package Algorithm;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class L491 {
	//这里用set是为了防止里面的temp重复***，这里是个小技巧
	Set<List<Integer>> result = new HashSet<List<Integer>>();
	
    public List<List<Integer>> findSubsequences(int[] nums) {
        
        if(nums.length == 0 || nums == null) {
        	return new ArrayList<List<Integer>>(result);
        }
        
        List<Integer> temp = new ArrayList<Integer>();
        backtracking(nums, result, temp, 0);
        
        return new ArrayList<List<Integer>>(result);
    }
    
    public void backtracking(int [] nums, Set<List<Integer>> result, List<Integer> temp, int start) {
    	if(temp.size() >= 2) {
    		result.add(new ArrayList<Integer>(temp));
    	}
    	
    	for(int i = start; i < nums.length; i ++) {
    		//因为题目中数组没有排序，所以需要看加入的元素是不是保证了有序
            if(temp.size() != 0 && (nums[i] < temp.get(temp.size()-1)))
    			continue;
        	temp.add(nums[i]);
        	backtracking(nums, result, temp, i + 1);
        	temp.remove(temp.size() - 1);
    	}
    }
    
    public static void main(String[] args) {
		int [] nums = {4,6,7,7};
		new L491().findSubsequences(nums);
	}
	
}
