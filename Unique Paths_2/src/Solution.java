/*
	A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

	The robot can only move either down or right at any point in time. The robot is trying to 
	reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

	How many possible unique paths are there?	
	
	Dynamic Programming
    
	The number of unique paths equals the sum of 
	the number of unique paths when omit last row and
	the number of unique paths when omit last column 
*/


public class Solution{
	public static int uniquePaths(int[][] obstacleGrid){
		int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;
		if(obstacleGrid[0][0] == 1 || obstacleGrid[m - 1][n - 1] == 1) return 0;
		int[][] paths = new int[m][n];
		for(int i = 0; i < m; i++){
			if(obstacleGrid[i][0] != 1)
				paths[i][0] = 1;
			else
				break;
		}
		for(int j = 0; j < n; j++){
			if(obstacleGrid[0][j] != 1)
				paths[0][j] = 1;
			else
				break;
		}
		for(int i = 1; i < m; i++){
			for(int j = 1; j < n; j++){
				if(obstacleGrid[i][j] != 1)
					paths[i][j] = paths[i][j - 1] + paths[i - 1][j];
			}
		}
		return paths[m - 1][n - 1];
	}
	
	public static void main(String args[]){
		//int[][] grid = {{0,0,0},{0,0,0},{0,0,0},{0,0,0},{0,0,0},{0,0,0},{0,0,0},{0,0,0},{0,0,0},{0,0,0},{0,0,0},{0,0,0},{0,0,0},{0,0,0},{0,1,0},{0,0,0},{0,0,0},{0,0,0},{0,0,0},{0,0,0},{0,0,0},{0,0,0},{0,0,0},{0,0,0},{0,0,0},{0,0,0},{0,0,0},{0,0,0},{0,0,0},{0,0,0},{0,0,0},{0,0,0},{0,0,0},{0,0,0},{0,0,0},{0,0,0},{0,0,0},{0,0,0},{0,0,0},{0,0,0},{0,0,0},{0,0,0},{0,0,0},{0,0,0},{0,0,0},{0,0,0},{0,0,0},{0,0,0},{0,0,0},{0,0,0},{0,0,0},{0,0,0},{0,0,0},{0,0,0},{0,0,0},{0,0,0},{0,0,0},{0,0,0},{0,0,0},{0,0,0},{0,0,0},{0,0,0},{0,0,0},{0,0,0},{0,0,0},{0,0,0},{0,0,0},{0,0,0},{0,0,0},{0,0,0},{0,0,0},{0,0,0},{0,0,0},{0,0,0},{0,0,0},{0,0,0},{0,0,0},{0,0,0},{0,0,0},{0,0,0},{0,0,0},{0,0,0},{0,0,0},{0,0,0},{0,0,0},{0,0,0},{0,0,0},{0,0,0},{0,0,0},{0,0,0},{0,0,0},{0,0,0},{0,0,0},{0,0,0},{0,0,0},{0,0,0},{0,0,0},{0,0,0},{0,0,0},{0,0,0}};
		int[][] grid = {{0,0},{1,1},{0,0}};
		System.out.println(uniquePaths(grid));
	}
	
}