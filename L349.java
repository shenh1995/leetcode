package Algorithm;

import java.util.HashSet;

public class L349 {
/*
 * 主要问题是要记住去重
 */
    public int[] intersection(int[] nums1, int[] nums2) {
        if(nums1 == null || nums2 == null)
        	return null;
        
        HashSet<Integer> hashSet = new HashSet<Integer>();
        HashSet<Integer> hashSet2 = new HashSet<Integer>();
        
        for(int i = 0; i < nums1.length; i ++) {
        	if(! hashSet.contains(nums1[i])) {
        		hashSet.add(nums1[i]);
        	}
        }
        
        for(int j = 0; j < nums2.length; j ++) {
        	if(hashSet.contains(nums2[j])) {
        		hashSet2.add(nums2[j]);
        	}
        }
        
        int [] result = new int [hashSet2.size()];
        int index = 0;
        for (int i : hashSet2) {
			result[index ++] = i; 
		}
        
        return result;
    }
}
