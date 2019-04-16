package leetcode;

public class L397 {
    public int integerReplacement(int n) {
        if(n == 1)
        	return 0;
        if(n == 2)
        	return 1;
        if(n == 3 || n == 4)
        	return 2;
        //这里是防止出现整数的最大值的情况		
        if(n == Integer.MAX_VALUE)
        	return 32;
        //利用递归的思想
        if(n % 2 == 0)
        	return 1 + integerReplacement(n / 2);
         return 1 + Math.min(integerReplacement(n + 1), integerReplacement(n - 1));
    }
}
