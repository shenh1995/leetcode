package Algorithm;

public class L326 {
/*
 * 这道题目可以设置一个死循环
 */
    public boolean isPowerOfThree(int n) {
    	while(true) {
    		if(n == 1)
    			return true;
    		if (n % 3 != 0 || n < 3)
				return false;
    		n = n / 3;
    	}
    }
    public static void main(String [] args) {
    	System.out.println(new L326().isPowerOfThree(27));
    }
	
}
