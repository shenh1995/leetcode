package Algorithm;

/*
 * 这里是字符串中的元音字母进行交换，一个从左往右，一个从右往左
 */
public class L345 {
	public String reverseVowels(String s) {
		if(s.length() == 0 || s == null) {
			return s;
		}
		int left = 0;
		int right = s.length() - 1;
		
		char [] resultChar = new char[s.length()];
		
		while(left <= right) {
			if(isVowel(s.charAt(left)) && isVowel(s.charAt(right))) {
                resultChar[left] = s.charAt(right);
                resultChar[right] = s.charAt(left);
                left ++;
                right --;
			}else if (isVowel(s.charAt(left))) {
				resultChar[right] = s.charAt(right);
				right --;
			}else if(isVowel(s.charAt(right))){
				resultChar[left] = s.charAt(left);
				left++;
			}else {
				resultChar[left] = s.charAt(left);
				resultChar[right] = s.charAt(right);
				left ++;
				right --;
			}
		}
		return new String(resultChar);
	}
	
	public boolean isVowel(char c) {
		return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
				c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
	}
	
	public static void main(String[] args) {
		System.out.println(new L345().reverseVowels("."));
	}
}
