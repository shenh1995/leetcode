package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class L241 {
	/*
	 * 解法：将子问题的计算结果保存下来，下次遇到同样的子问题就直接从备忘录中取出，从而免去繁琐的计算，具体的做法是新建一个hashmap
	 * ，将子字符串放入hashmap中，对应的计算结果放入value中。
	 */
	HashMap<String, List<Integer>> hm = new HashMap<String, List<Integer>>();
	public List<Integer> diffWaysToCompute(String input) {   
		if(hm.containsKey(input))
			return hm.get(input);
		List<Integer> res = new  ArrayList<Integer>();
		for(int i = 0; i < input.length(); i ++) {
			char ch = input.charAt(i);
			if(ch == '+' || ch == '-' || ch == '*') {
				//这儿是两边都要计算
				for(Integer l : diffWaysToCompute(input.substring(0, i)))
					for(Integer r : diffWaysToCompute(input.substring(i + 1, input.length()))) {
						if(ch == '+')
							res.add(l + r);
						else if (ch == '-') {
							res.add(l - r);
						}else {
							res.add(l * r);
						}
					}
			}
		}
		//这里的意思是，假如input是纯数字
		if(res.size() == 0)
			res.add(Integer.valueOf(input));
		hm.put(input, res);
		return res;
	}
}
