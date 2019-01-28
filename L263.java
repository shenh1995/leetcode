package Algorithm;

/*
 * 丑数判断
 */
public class L263 {
    public boolean isUgly(int num) {      
    if(num == 0)
    	return false;
    //因为1也是丑数
    if(num == 1)
        return true;
    while(num % 5 == 0) {
    	num = num / 5;
    }
    if(num == 1) 
    	return true;
    while(num % 3 == 0) {
    	num = num / 3;
    }
    if(num == 1) 
    	return true;
    while(num % 2 == 0) {
    	num = num / 2;
    }
    if(num == 1) 
    	return true;
    return false;
   }
    public static void main(String[] args) {
		System.out.println(new L263().isUgly(14));
	}
}
