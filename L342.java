package Algorithm;

public class L342 {
	/*
	 * 判断一个数是不是4的幂，
	 * 思路：首先判断是否为2的幂，如果是的话，再去判断是否为4的倍数，如果是的话，那么就表示这个数是4的幂。
	 * 对于判断是否为2的幂，只需要根据num & (num - 1)是否为0来判断。
	 * 对于判断是否为4的倍数，如果一个数是4的倍数，那么这个数-1一定可以被3整除，可以用数学归纳法来证明。
	 */
    public boolean isPowerOfFour(int num) {
        if(num < 0)
        	return false;
        
        int tmp = num - 1;
        return (num & tmp) == 0 && tmp % 3 == 0;
        
    }

}
