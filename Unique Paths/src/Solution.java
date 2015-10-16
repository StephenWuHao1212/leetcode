/*
	A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

	The robot can only move either down or right at any point in time. The robot is trying to 
	reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

	How many possible unique paths are there?	
	
	Dynamic Programming
    

    The number of unique path of your right block and your down block is 1

    Total path equals to the number of unique path of your right block
   	plus the number of unique path of your down block

   	paths[i][j][m][n] stores the number of unique path from block
   	(i, j) to (m, n)
*/


public class Solution{
	public static int uniquePaths(int m, int n){
		if(m < 1 || n < 1) return 1;
		int[][][][] paths = new int[m][n][m][n];
		for(int i = 0; i < m; i++){
			for(int j = 0; j < n; j++){
				for(int a = 0; a < m; a++){
					for(int b = 0; b < n; b++){
						if(i == a) {
							if(j == b) paths[i][j][a][b] = 0;
							else if(b > j) paths[i][j][a][b] = 1;
						}
						else if(j == b){ 
							if(i == a) paths[i][j][a][b] = 0;
							else if (a > i) paths[i][j][a][b] = 1;
						}
						else paths[i][j][a][b] = Integer.MIN_VALUE;
					}
				}
			}
		}
		
		paths = helper(paths, 0, 0, m - 1, n - 1, m, n);
		return paths[0][0][m - 1][n - 1];
	}
	public static int[][][][] helper(int[][][][] paths, int i, int j, int a, int b, int m, int n){
		if(paths[i][j][a][b] == Integer.MIN_VALUE){
			int temp;
			if(i + 1 < m){
				paths = helper(paths, i + 1, j, a, b, m, n);
				temp = paths[i + 1][j][a][b];
			} 
			if(j + 1 < n){
				paths = helper(paths, i, j + 1, a, b, m, n);
				temp = paths[i][j + 1][a][b];
			}
			paths[i][j][a][b] = paths[i + 1][j][a][b] + paths[i][j + 1][a][b];
			return paths;
		}
		else return paths;
	}
	
	public static void main(String args[]){
		System.out.println(uniquePaths(3,3));
	}
	
}