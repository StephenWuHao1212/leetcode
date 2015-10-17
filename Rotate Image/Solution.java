/*
	You are given an n x n 2D matrix representing an image.

	Rotate the image by 90 degrees (clockwise).

	Follow up:
	Could you do this in-place?
*/

public class Solution {
    public void rotate(int[][] matrix) {
        int len = matrix[0].length;
        if(len > 1){
            int[][] newMatrix = new int[len][len];
            for(int i = 0; i < len; i++){
                for(int j = 0; j < len; j++){
                    newMatrix[i][j] = matrix[len - 1 - j][i];
                }
            }
            for(int i = 0; i < len; i++){
                for(int j = 0; j < len; j++){
                    matrix[i][j] = newMatrix[i][j];
                }
            }
        }
    }
}