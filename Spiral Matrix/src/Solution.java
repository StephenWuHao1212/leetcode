/*
	Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

	For example,
	Given the following matrix:
	
	[
	 [ 1, 2, 3 ],
	 [ 4, 5, 6 ],
	 [ 7, 8, 9 ]
	]
	You should return [1,2,3,6,9,8,7,4,5].


	need x and y index to represent the current position of the number
	initialize x and y to be 0
	set up initial x and y index to be 0
	loop:
		if number of rows or number of columns equals to 0,
			return ans
		if number of rows equals to 1
			add the whole row into the ans
			return ans
		else if number of columns equals to 1
			add the whole column into the ans
			return ans
		else
			add a circle into the ans
			update the number of rows and columns
			update the initial x and y
			
*/


import java.util.*;
public class Solution {
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new LinkedList<Integer>();
        if(matrix.length == 0) return ans;
        int m = matrix.length;
        int n = matrix[0].length;
        int initialX = 0;
        int initialY = 0;
        while(true){
        	if(m == 0 || n == 0) return ans;
        	if(m == 1){
        		for(int i = 0; i < n; i++){
        			ans.add(matrix[initialX][initialY + i]);
        		}
        		return ans;
        	}
        	else if(n == 1){
        		for(int i = 0; i < m; i++){
        			ans.add(matrix[initialX + i][initialY]);
        		}
        		return ans;
        	}
        	else{
        		int i = 0;
        		for(i = 0; i < n; i++){
        			ans.add(matrix[initialX][initialY + i]);
        		}
        		for(i = 1; i < m; i++){
        			ans.add(matrix[initialX + i][initialY + n - 1]);
        		}
        		for(i = 0; i < n - 1; i++){
        			ans.add(matrix[initialX + m - 1][initialY + n - 2 - i]);
        		}
        		for(i = 0; i < m - 2; i++){
        			ans.add(matrix[initialX + m - 2 - i][initialY]);
        		}
        		m -= 2;
        		n -= 2;
        		initialY++;
        		initialX++;
        	}
        }
    }
    
    public static void main(String[] args){
    	int[][] matrix = {{1,2,3}, {4,5,6}, {7,8,9}};
    	System.out.println(spiralOrder(matrix));
    	int[][] matrix1 = {{1,2,3}};
    	System.out.println(spiralOrder(matrix1));
    	int[][] matrix2 = {{1},{2},{3}};
    	System.out.println(spiralOrder(matrix2));
    	int[][] matrix3 = {};
    	System.out.println(spiralOrder(matrix3));
    	int[][] matrix4 = {{1}};
    	System.out.println(spiralOrder(matrix4));
    	int[][] matrix5 = {{1,2,3,4},{5,6,7,8}};
    	System.out.println(spiralOrder(matrix5));
    	int[][] matrix6 = {{1,2},{3,4},{5,6},{7,8}};
    	System.out.println(spiralOrder(matrix6));
    	int[][] matrix7 = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
    	System.out.println(spiralOrder(matrix7));
    }
}










