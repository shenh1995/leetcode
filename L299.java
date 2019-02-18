package Algorithm;

/*
 * https://baike.baidu.com/item/%E7%8C%9C%E6%95%B0%E5%AD%97/83200?fr=aladdin
 */
public class L299 {
    public String getHint(String secret, String guess) {
    	int len = secret.length();
    	
    	int A = 0;
    	int B = 0;
    	int [] count = new int [10];
    	
    	for(int i = 0; i < len; i ++) {
    		int s = secret.charAt(i) - '0';
    		int g = guess.charAt(i) - '0';
    		if(s == g) {
    			A ++;
    		}else {
				if(count[g] > 0) { //如果g这里之前多出一个和g匹配的则B加1
					B ++;
				}
				if(count[s] < 0) { //如果之前少一个和s匹配的，则B加1
					B ++;
				}
				
				count[g] --; //缺一个和g匹配的
				count[s] ++; //s这里多一个匹配的
			}
    	}
    	return A + "A" + B + "B";
    }
}
