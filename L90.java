package Algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L90 {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
    	if(nums.length == 0 || nums == null) {
    		return null;
    	}
    	
    	List<List<Integer>> results = new ArrayList<List<Integer>>();
    	List<Integer> temp = new ArrayList<Integer>(); 
    	Arrays.sort(nums);  //要先排序，去除重复的元素
    	backtracking(results, temp, nums, 0);
    	
    	return results;
    }
    
    public void backtracking(List<List<Integer>> results, List<Integer> temp, int [] nums, int start) {
    	results.add(new ArrayList<Integer>(temp));
    	
    	for(int i = start; i < nums.length; i ++) {
    		if(i > start && nums[i]==nums[i-1])
    			continue;
               temp.add(nums[i]);
               backtracking(results, temp, nums, i + 1);
               temp.remove(temp.size() - 1);
    	}
    }
}
