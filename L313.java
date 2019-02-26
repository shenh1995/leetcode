package Algorithm;

/*
 * 可以先看L264，丑数2，思想基本一样
 * 
 */
public class L313 {
	 public int nthSuperUglyNumber(int n, int[] primes) {
		 int [] dp = new int[n];
		 //第一个丑数为1
		 dp[0] = 1;
		 int [] idxPrimes = new int [primes.length];
		 int counter = 1;
		 while (counter < n) {
			int min = Integer.MAX_VALUE;
			//这里的思想和丑数2是一样的
			for(int i = 0; i < primes.length; i ++) {
				int temp = dp[idxPrimes[i]] * primes[i];
				min = min < temp ? min : temp;
			}
			/*
			 * 这里因为比如说primes为 2 7 13 19
			 * idxPrimes[i]开始全部为0，经过第一轮后，idxPrimes[0] = 1,其余为0，
			 * 这样新一轮temp下来，依次为4 7 13 19，idxPrimes[0] = 2,其余为0，
			 * 
			 */
			
			for(int i = 0; i < primes.length; i ++) {
				if(min == dp[idxPrimes[i]] * primes[i])
					idxPrimes[i] ++;
			}
			dp[counter] = min;
			counter ++;
		}
		 return dp[n - 1];
	 }
}
