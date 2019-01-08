package Algorithm;

import java.util.LinkedList;

public class huawei_3 {
	
	public static int shortestPathLength = Integer.MAX_VALUE;
	public static String res = "";
	
	//查找最短路径
	public String findShortestPath(String input) {
		if(input.length() == 0 || input == null)
			return "";

		LinkedList<String> pathList = new LinkedList<String>();
		
		String [] input_divide_by_blank = input.split(" ");
		//构建存在的矩阵
		String [] matrixSize = input_divide_by_blank[0].split(",");
		int [][] matrix = new int [Integer.parseInt(matrixSize[0]) + 1][Integer.parseInt(matrixSize[1]) + 1];
		
		//找出起点和终点
		String [] start_Point = input_divide_by_blank[1].split(",");
		String [] end_Point = input_divide_by_blank[2].split(",");
		
		for(int i = 0; i < Integer.parseInt(matrixSize[0]) + 1; i ++) {
			for(int j = 0; j < Integer.parseInt(matrixSize[0]) + 1; j ++) {
				matrix[i][j] = 0;
			}
		}
		
		//找出障碍点数,题目中的障碍物的个数是个多余条件
		//int obstacle_point_num = Integer.parseInt(input_divide_by_blank[3]);
		
		//将障碍点的地方设置为1
		for(int i = 4; i < input_divide_by_blank.length; i ++) {
			String [] obstacle_point = input_divide_by_blank[i].split(",");
			matrix[Integer.parseInt(obstacle_point[0])][Integer.parseInt(obstacle_point[1])] = 1;
		}
	   
		pathList.addLast("[" + Integer.parseInt(start_Point[0]) + "," + Integer.parseInt(start_Point[1]) + "]");
		deepSearch(pathList, matrix, Integer.parseInt(end_Point[0]), Integer.parseInt(end_Point[1]), Integer.parseInt(start_Point[0]), Integer.parseInt(start_Point[1]), 1);
	    
		System.out.println(res);
	    return res;
	}
	
	//深度搜索并回溯
	public void deepSearch(LinkedList<String> pathList, int [][] matrix, int end_point_x, int end_point_y, int now_point_x, int now_point_y, int length) {
	   //回溯的出口
		if(now_point_x == end_point_x && now_point_y == end_point_y) {
			if(length < shortestPathLength) {
				res = "";
			    for(int i = 0; i < pathList.size(); i ++) {
			    	res += pathList.get(i);
			    }
				shortestPathLength = length;
			}
			return ;
		}
		
		int matrix_size = matrix[0].length;
		
		//按照上下左右的顺序
		if(now_point_x - 1 >= 0 && now_point_x - 1 < matrix_size) {
			if(matrix[now_point_x - 1][now_point_y] == 0) {
				matrix[now_point_x - 1][now_point_y] = 1;
				pathList.addLast("["+ (now_point_x - 1) + "," + now_point_y + "]");
				deepSearch(pathList, matrix, end_point_x, end_point_y, now_point_x - 1, now_point_y, length + 1);
				matrix[now_point_x - 1][now_point_y] = 0;
				pathList.removeLast();
			}
		}
	    if(now_point_x + 1 >= 0 && now_point_x + 1 < matrix_size) {
			if(matrix[now_point_x + 1][now_point_y] == 0) {
				matrix[now_point_x + 1][now_point_y] = 1;
				pathList.addLast("["+ (now_point_x + 1) + "," + now_point_y + "]");
				deepSearch(pathList, matrix,  end_point_x, end_point_y, now_point_x + 1, now_point_y, length + 1);
				matrix[now_point_x + 1][now_point_y] = 0;
				pathList.removeLast();
			}	    	
	    }
		if(now_point_y - 1 >= 0 && now_point_y - 1 < matrix_size) {
			if(matrix[now_point_x][now_point_y - 1] == 0) {
				matrix[now_point_x][now_point_y - 1] = 1;
				pathList.addLast("["+ now_point_x + "," + (now_point_y - 1) + "]");
				deepSearch(pathList, matrix, end_point_x, end_point_y, now_point_x, now_point_y - 1, length + 1);
				matrix[now_point_x][now_point_y - 1] = 0;
				pathList.removeLast();
			}
		}	    
		if(now_point_y + 1 >= 0 && now_point_y + 1 < matrix_size) {
			if(matrix[now_point_x][now_point_y + 1] == 0) {
				matrix[now_point_x][now_point_y + 1] = 1;
				pathList.addLast("["+ now_point_x + "," + (now_point_y + 1) + "]");
				deepSearch(pathList, matrix, end_point_x, end_point_y, now_point_x, now_point_y + 1, length + 1);
				matrix[now_point_x][now_point_y + 1] = 0;
				pathList.removeLast();
			}
		}		    
		return ;
	}
	
	public static void main(String [] args) {
		new huawei_3().findShortestPath("2,2 0,0 2,2 3 0,1 2,0 2,1");
	}
	
}
