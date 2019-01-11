package Algorithm;

import java.util.Arrays;

public class L130 {
   //深度搜索连通子图，本道题目只需要把位于周边的连通子图找出来标为*，那么其余O就表示被X包围了
	public void solve(char[][] grid) {
		if(grid == null)
			return;
		int row = grid.length;
		if(row <= 0)
			return;
		int col = grid[0].length;
		if(col <= 0)
			return;
		for(int i = 0; i < row; i ++) {
			if(grid[i][0] == 'O')
				dfsSearch(grid, i, 0);
			if (grid[i][col - 1] == 'O')
				dfsSearch(grid, i, col - 1);
		}
		for(int j = 0; j < col; j ++) {
			if(grid[0][j] == 'O')
				dfsSearch(grid, 0, j);
			if(grid[row - 1][j] == 'O')
				dfsSearch(grid, row - 1, j);
		}
		
		for(int i = 0; i < row; i ++) {
			for(int j = 0; j < col; j ++) {
				if(grid[i][j] == '*')
					grid[i][j] = 'O';
				else if(grid[i][j] == 'O')
					grid[i][j] = 'X';
			}
		}
		for(int i = 0; i < row; i ++)
			System.out.println(Arrays.toString(grid[i]));
	}
	//每遇到'O'后，开始向四个方向递归搜索，搜到后变为'*'
	//因为相邻的属于一个island，然后开始继续找下一个'O'
	private void dfsSearch(char [][] grid, int i, int j) {
		if(grid[i][j] == 'O') {
			//修改为一个不相干的字符，但不能是X
			grid[i][j] = '*'; //和visited数组一样功能
			//不需要处理四周边缘了，调用循环已经处理过，不然超时
			if(i < grid.length - 2)
				dfsSearch(grid, i + 1, j);
			if(i > 1)
				dfsSearch(grid, i - 1, j);
			if(j < grid[0].length - 2)
				dfsSearch(grid, i, j + 1);
			if(j > 1)
				dfsSearch(grid, i, j - 1);
		}
	}
	
	public static void main(String [] args) {
		char [][] grid = {{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
		new L130().solve(grid);
        
	}
}
