package Algorithm;

import java.util.Collections;
import java.util.PriorityQueue;
/*
 * 此道题目可以维护一个优先队列作为一个大顶堆，堆顶就是最大的数
 */
public class L239 {

    public int[] maxSlidingWindow(int[] nums, int k) {
    	if(nums.length == 0 || nums == null) {
    		return new int[0];
    	}
    	int [] result = new int [nums.length + 1 - k];
    	PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
    	for(int i = 0; i < nums.length; i++) {
    		//去掉最左边的数
    		if (i >= k) 
    			pq.remove(nums[i - k]);
    		//将新的数加入到窗口中
    		pq.offer(nums[i]);
    		//堆顶就是最大值
    		if(i + 1 >= k) {
    			result[i - k + 1] = pq.peek();
    		}
    	}
    	return result;
    }
	
}
