package Algorithm;

public class L344 {
	/*
	 * 字符串数字反转
	 */
    public String reverseString(String s) {
        if(s.length() == 0 || s == null) {
        	return "";
        }
        
        StringBuilder res = new StringBuilder();
        
        for(int i = s.length() - 1; i >= 0; i --) {
        	res.append(s.charAt(i));
        }
        
        return res.toString();
    }
}
