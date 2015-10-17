/*
	Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.

	The Sudoku board could be partially filled, where empty cells are filled with the character '.'.

	Note:
	A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated
*/


public class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Integer> row = new HashSet<Integer>();
        HashSet<Integer> col = new HashSet<Integer>();
        HashSet<Integer> square = new HashSet<Integer>();
        int dot = 58;
        for(int i = 0; i < 9; i++){
            row.clear(); col.clear();
            for(int j = 0; j < 9; j++){
                int currRow; int currCol;
                if(board[i][j] == '.'){
                    currRow = dot;
                    dot++;
                }
                else currRow = (int)board[i][j];
                
                if(board[j][i] == '.'){
                    currCol = dot;
                    dot++;
                }
                else currCol = (int)board[j][i];
                row.add(currRow);
                col.add(currCol);
            }
            if(row.size() != 9 || col.size() != 9) return false;
        }
        for(int i = 1; i < 9; i += 3){
            for(int j = 1; j < 9; j += 3){
                square.clear();
                for(int a = -1; a < 2; a++){
                    for(int b = -1; b < 2; b++){
                        int curr;
                        if(board[i + a][j + b] == '.'){
                            curr = dot;
                            dot++;
                        }
                        else curr = (int)board[i + a][j + b];
                        square.add(curr);
                    }
                }  
                if(square.size() != 9) return false;
            }
        }
        return true;
    }
}