/*

	Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.

	click to show follow up.
	
	Follow up:
	Did you use extra space?
	A straight forward solution using O(mn) space is probably a bad idea.
	A simple improvement uses O(m + n) space, but still not the best solution.
	Could you devise a constant space solution?
	
	
	
	use the first row and column to record the status of that row

*/

public class Solution {
    public void setZeroes(int[][] matrix) {
        boolean zerorow = false;
        boolean zerocol = false;
        int m = matrix.length;
        int n = matrix[0].length;
        for(int i = 0; i < n; i++){
        	if(matrix[0][i] == 0) {
        		zerorow = true;
        		break;
        	}
        }
        for(int i = 0; i < m; i++){
        	if(matrix[i][0] == 0) {
        		zerocol = true;
        		break;
        	}
        }
        for(int i = 1; i < m; i++){
        	for(int j = 1; j < n; j++){
        		if(matrix[i][j] == 0){
        			matrix[i][0] = 0;
        			matrix[0][j] = 0;
        		}
        	}
        }
        for(int i = 1; i < m; i++){
        	for(int j = 1; j < n; j++){
        		if(matrix[i][0] == 0 || matrix[0][j] == 0){
        			matrix[i][j] = 0;
        		}
        	}
        }
        if(zerorow){
        	for(int i = 0; i < n; i++){
        		matrix[0][i] = 0;
            }
        }
        if(zerocol){
        	 for(int i = 0; i < m; i++){
        		 matrix[i][0] = 0;
             }
        }
    }
}