package Algorithm;

/*
 * 	解题：这道题主要是让判断needle是不是haystack的子串，那么从haystack的第一个位置开始判断是不是子串
 * 如果needle的整个子串都匹配了，那么就返回，否则继续往下挪动
 * 如果说haystack的剩余长度比needle要短，那么就不用往后面再比了
 */
public class L28 {
	public int strStr(String haystack, String needle) {
		for(int i = 0; ; i ++) {
			for(int j = 0; ; j ++) {
				if(j == needle.length()) return i;
				if(i + j == haystack.length()) return -1;
				if(needle.charAt(j) != haystack.charAt(i + j)) break;
			}
		}
	}
}
