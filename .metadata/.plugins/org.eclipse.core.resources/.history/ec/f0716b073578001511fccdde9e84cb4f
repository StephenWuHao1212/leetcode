/*
	Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
	
	For example,
	Given n = 3,
	
	You should return the following matrix:
	[
	 [ 1, 2, 3 ],
	 [ 8, 9, 4 ],
	 [ 7, 6, 5 ]
	]
	
	
	like the spiral matrix 1, process the matrix as circle-based matrix. until there is only one 
	row or one column
	
	m rows, n columns(in this case, m = n)
	circle:
	1. initialX, initialY ~ initialY + n - 1
	2. initialX + 1 ~ initialX + m - 1, initialY + n - 1
	3. initialX + m - 1, initialY + n - 2 ~ initialY
	4. initialX + m - 2 ~ initialX + 1, initialY
	
	if only one row
		initialX, initialY ~ initialY + n - 1
	if only one column
		initialX ~ initialX + m - 1, initialY
*/

public class Solution {
    public static int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
        int initialX = 0;
        int initialY = 0;
        int num = 1;
        while(true){
        	if(n == 0) return ans;
        	else if(n == 1){
        		ans[initialX][initialY] = num;
        		return ans;
        	}
        	else{
        		for(int i = 0; i < n; i++){
        			ans[initialX][initialY + i] = num;
        			num++;
        		}
        		for(int i = 1; i < n; i++){
        			ans[initialX + i][initialY + n - 1] = num;
        			num++;
        		}
        		for(int i = 0; i < n - 1; i++){
        			ans[initialX + n - 1][initialY + n - 2 - i] = num;
        			num++;
        		}
        		for(int i = 0; i < n - 2; i++){
        			ans[initialX + n - 2 - i][initialY] = num;
        			num++;
        		}
        		initialX++;
        		initialY++;
        		n -= 2;
        	}
        }
    }
    
    public static void main(String[] args){
    	System.out.println(generateMatrix(0));
    	System.out.println(generateMatrix(1));
    	System.out.println(generateMatrix(2));
    	System.out.println(generateMatrix(3));
    	System.out.println(generateMatrix(4));
    	System.out.println(generateMatrix(5));

    }
}