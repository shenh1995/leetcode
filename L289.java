package Algorithm;

/*
 * 因为此题目需要改变二维数组里面的值，所以会影响到对周围存活节点的计算。一定需要下面这样编码
 * 0 : 上一轮是0，这一轮过后还是0
1 : 上一轮是1，这一轮过后还是1--本来上一轮是0，下轮是1表示为1，但是这样是为了保持原样的时候写代码简单
2 : 上一轮是1，这一轮过后变为0
3 : 上一轮是0，这一轮过后变为1
因此若是0，1则之前是死亡状态；2,3则之前是存活状态
 */
public class L289 {

    public void gameOfLife(int[][] board) {
    	if(board[0].length == 0 || board == null) {
    		return ;
    	}
    	int row = board.length;
    	int col = board[0].length;
    	for(int i = 0; i < row; i ++) {
    		for(int j = 0; j < col; j ++) {
    			int count = neighborsBoard(board, row, col);
    			if(count == 2)
    				continue;
    			
    			if(count == 3) {
    				board[i][j] = board[i][j] == 0 ? 3 : 1;
    			}else {
					board[i][j] = board[i][j] == 1 ? 2 : 0;
				}
    				
    		}
    	}
    	//因为看变完后的，1有1 3 两种状态，0有0 2两种状态，经过模2运算后就可以知道是1还是0
    	for(int i = 0 ; i < row; i ++) {
    		for(int j = 0; j < col; j ++) {
    			board[i][j] = board[i][j] % 2;
    		}
    	}
    }
    public int neighborsBoard(int [][] board, int row, int col) {
    	int count = 0;
    	for(int i = row - 1; i < row + 1; i ++) {
    		for(int j = col - 1; j < col + 1; j ++) {
    			if(i == row && j == col) {
    				continue;
    			}
    			//这里board[i][j] == 1或者为2的原因是board[i][j]原来为1
    			if(i >= 0 && i < board.length && j >= 0 && j < board[0].length && (board[i][j] == 1 || board[i][j] == 2)) {
    				count ++;
    			}
    		}
    	}
    	return count;
    }
}
