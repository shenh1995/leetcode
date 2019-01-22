package Algorithm;

public class L201 {

	/*
	 * 题意：从m到n之间的数字按位与，得到的数字是哪个？？
	 * 
	 * 解答，比如m = 5 n = 7 
	 * 总共有三个数字 101 110 111
	 * 那么与出来的数字为100 = 4
	 * 即目的是找出这几个数字左边公共的部分即可
	 * d为32位的最大数字  111111....1111 往左移一位是111....1110
	 * 这样一直与m和n与就可以得到最左边的公共部分。
	 */
	public int rangeBitwiseAnd(int m, int n) {
		
		int d = Integer.MAX_VALUE;
		
		while((m & d) != (n & d)) {
			d <<= 1;
		}
		
		return m & d;
	}
	
}
