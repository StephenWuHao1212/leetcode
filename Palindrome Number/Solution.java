/*
	Determine whether an integer is a palindrome. Do this without extra space.
*/

public class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0) return false;
        int tar = 0;
        int tmp = x;
        while(x != 0){
            tar = tar * 10 + x % 10;
            x = x / 10;
        }
        if(tar == tmp) return true;
        else return false;
    }
}