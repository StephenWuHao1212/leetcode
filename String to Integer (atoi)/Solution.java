/*

Implement atoi to convert a string to an integer.

Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself what are the possible input cases.

Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). You are responsible to gather all the input requirements up front

*/

public class Solution {
    public int myAtoi(String str) {
        if(str.isEmpty()) return 0;
        if(str.length() == 1){
            int tmp = (int)str.charAt(0);
            if(tmp >= 48 && tmp <= 57) return tmp - 48;
        }
        long ans = 0;
        int sign = 1;
        for(int i = 0; i < str.length(); i++){
            int start = (int)str.charAt(i);
            if(start == 32 || start == 48) continue;
            else{
                if(start == 43 || start == 45 || (start > 48 && start <= 57)){
                    if(start > 48 && start <= 57) ans = start - 48;
                    for(int j = i + 1; j < str.length(); j++){
                        int end = (int)str.charAt(j);
                        if(end < 48 || end > 57) return (int)(sign * ans);
                        if(j == i + 1){
                            if(start == 43){ 
                                if(end == 48) continue;
                                else{
                                    ans = 10 * ans + end - 48;
                                }
                            }
                            else if(start == 45){ 
                                sign = -1;
                                if(end == 48) continue;
                                else{
                                    ans = 10 * ans + end - 48;
                                }
                            }
                            else ans = 10 * (start - 48) + end - 48;
                        }
                        else{
                            ans = 10 * ans + end - 48;
                            if(sign * ans > Integer.MAX_VALUE) return Integer.MAX_VALUE;
                            if(sign * ans <= Integer.MIN_VALUE) return Integer.MIN_VALUE;
                        }
                    }
                    return (int)(sign * ans);
                }
                else return 0;
            }
        }
        return (int)(sign * ans);
    }
}