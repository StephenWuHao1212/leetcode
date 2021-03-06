/*
	Given a m x n grid filled with non-negative numbers, 
	find a path from top left to bottom right which minimizes the sum of all numbers along its path.

	Note: You can only move either down or right at any point in time.
	
	
	if m == 1 or n == 1
		return the cumulative sum 
	else
		create a m * n matrix to store the sum from (0,0) to that point
		for all n, matrix[0][n] equals to the cumulative sum for the previous nodes
		for all m, matrix[m][0] equals to the cumulative sum for the previous nodes
		loop i from 1 to n - 1
			loop j from 1 to m - 1
				matrix[i][j] = min(original number + matrix[i-1][j], original number + matrix[i][j-1])
		return matrix[m - 1][n - 1]
*/

public class Solution {
    public static int minPathSum(int[][] grid) {
    	int m = grid.length;
    	int n = grid[0].length;
    	int[][] matrix = new int[m][n];
    	int tmp = grid[0][0];
    	matrix[0][0] = grid[0][0];
    	for(int i = 1; i < m; i++){
    		tmp += grid[i][0];
    		matrix[i][0] = tmp;
    	}
    	tmp = grid[0][0];
    	for(int i = 1; i < n; i++){
    		tmp += grid[0][i];
    		matrix[0][i] = tmp;
    	}
    	for(int i = 1; i < m; i++){
    		for(int j = 1; j < n; j++){
    			matrix[i][j] = Math.min(grid[i][j] + matrix[i - 1][j], grid[i][j] + matrix[i][j - 1]);
    		}
    	}
    	return matrix[m - 1][n - 1];
    }
    
    public static void main(String[] args){
    	int[][] grid = {{1,2,3},{4,5,6},{7,8,9}};
    	System.out.println(minPathSum(grid));
       	int[][] grid1 = {{1,2,3},{4,5,6},{7,8,9},{10,11,12}};
    	System.out.println(minPathSum(grid1));
     	int[][] grid2 = {{1,2,3}};
    	System.out.println(minPathSum(grid2));
    	int[][] grid3 = {{1},{2},{3}};
    	System.out.println(minPathSum(grid3));
    	int[][] grid4 = {{1}};
    	System.out.println(minPathSum(grid4));
    } 
}