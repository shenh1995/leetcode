package leetcode;

import java.util.ArrayList;
import java.util.List;

public class L442 {
	/*
	 * ����1��������ĿҪ�󣺸�����֤����������������ͬ���������߳���һ��ĳ������Ҫ�󲻿��ٿռ䣬
	 * ʱ�临�Ӷ���O(n).��Ϊ����������ص� 1<=sums[i]<=n,����԰�ԭ���鵱hash���� ��
	 * ��Ϊԭ��������������Ϊ������ʾ���ֹ�������������� �ͱ�ʾ�ڶ��γ��֣��Ϳ����ҳ����г��ֹ�2�ε���
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
