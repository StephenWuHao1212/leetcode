/*
	Given a roman numeral, convert it to an integer.

	Input is guaranteed to be within the range from 1 to 3999.
*/

public class Solution {
    public int romanToInt(String s) {
        int ans = 0;
        for(int i = s.length() - 1; i >= 0; i--){
            char curr = s.charAt(i);
            switch(curr){
                case 'I': ans += 1; break;
                case 'V': 
                    if(i != 0 && s.charAt(i - 1) == 'I'){
                        ans += 4;
                        i--;
                    }
                    else ans += 5;
                    break;
                case 'X':
                    if(i != 0 && s.charAt(i - 1) == 'I'){
                        ans += 9;
                        i--;
                    }
                    else ans += 10;
                    break;  
                case 'L': 
                    if(i != 0 && s.charAt(i - 1) == 'X'){
                        ans += 40;
                        i--;
                    }
                    else ans += 50;
                    break;
                case 'C':
                    if(i != 0 && s.charAt(i - 1) == 'X'){
                        ans += 90;
                        i--;
                    }
                    else ans += 100;
                    break;
                case 'D': 
                    if(i != 0 && s.charAt(i - 1) == 'C'){
                        ans += 400;
                        i--;
                    }
                    else ans += 500;
                    break;
                case 'M':
                    if(i != 0 && s.charAt(i - 1) == 'C'){
                        ans += 900;
                        i--;
                    }
                    else ans += 1000;
                    break;
            }
        }
        return ans;
    }
}