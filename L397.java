package leetcode;

public class L397 {
    public int integerReplacement(int n) {
        if(n == 1)
        	return 0;
        if(n == 2)
        	return 1;
        if(n == 3 || n == 4)
        	return 2;
        //�����Ƿ�ֹ�������������ֵ�����		
        if(n == Integer.MAX_VALUE)
        	return 32;
        //���õݹ��˼��
        if(n % 2 == 0)
        	return 1 + integerReplacement(n / 2);
         return 1 + Math.min(integerReplacement(n + 1), integerReplacement(n - 1));
    }
}
