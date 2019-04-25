package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class L241 {
	/*
	 * �ⷨ����������ļ����������������´�����ͬ�����������ֱ�Ӵӱ���¼��ȡ�����Ӷ���ȥ�����ļ��㣬������������½�һ��hashmap
	 * �������ַ�������hashmap�У���Ӧ�ļ���������value�С�
	 */
	HashMap<String, List<Integer>> hm = new HashMap<String, List<Integer>>();
	public List<Integer> diffWaysToCompute(String input) {   
		if(hm.containsKey(input))
			return hm.get(input);
		List<Integer> res = new  ArrayList<Integer>();
		for(int i = 0; i < input.length(); i ++) {
			char ch = input.charAt(i);
			if(ch == '+' || ch == '-' || ch == '*') {
				//��������߶�Ҫ����
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
		//�������˼�ǣ�����input�Ǵ�����
		if(res.size() == 0)
			res.add(Integer.valueOf(input));
		hm.put(input, res);
		return res;
	}
}
