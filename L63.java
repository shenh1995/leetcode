package Algorithm;

public class L63 {

	public int uniquePathsWithObstacles(int [][] obstacleGrid) {
		int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;
		
		int [][] dp = new int [m][n];
		//这里是要排除0 0 位置就为1的情况，这样肯定就是返回0，其余的思想基本和L62相似
		if(obstacleGrid[0][0] == 1)
			return 0;
		dp[0][0] = 1;
		
		//这里不全是1，是看前一个是什么
		for(int i = 1; i < n; i ++) {
			if(obstacleGrid[0][i] == 1) {
				dp[0][i] = 0;
			}else {
				dp[0][i] = dp[0][i - 1];
			}
		}
		
		for(int j = 1; j < m; j ++) {
			if(obstacleGrid[j][0] == 1) {
				dp[j][0] = 0;
			}else {
				dp[j][0] = dp[j - 1][0];
			}
		}
		
		for(int i = 1; i < m; i ++) {
			for(int j = 1; j < n; j ++) {
				if(obstacleGrid[i][j] == 1) {
					dp[i][j] = 0;
				}else {
					dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
				}
			}
		}
		return dp[m - 1][n - 1];
	}
}
