package leetcode;

public class L413 {
	/*
	 * ���ǻ�������DP����������һ��һάdp���飬����dp[i]��ʾ��
	 * ��iλ��Ϊֹ��������Ƭ�ĸ�������ô���Ǵӵ��������ֿ�ʼ������
	 * �����ǰ���ֺ�֮ǰ�������ֹ���������Ƭ����ô���Ǹ���dp[i]Ϊdp[i-1]+1��
	 * Ȼ��res�ۼ���dp[i]��ֵ���ɣ�
	 */
	public int numberOfArithmeticSlices(int[] A) {
		int res = 0, cur = 0;
		for(int i = 2; i < A.length; i ++) {
			if(A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
				cur += 1;
				res += cur;
			}else {
				cur = 0;
			}
		}
		return res;
	}
}
