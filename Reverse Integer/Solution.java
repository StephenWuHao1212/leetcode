/*

	Reverse digits of an integer.

	Example1: x = 123, return 321
	Example2: x = -123, return -321 

*/



public class Solution {
    public int reverse(int x) {
        if(x == 0) return x;
        int sign;
        if(x < 0) sign = -1;
        else sign = 1;
        x = Math.abs(x);
        Stack st = new Stack();
        while(x != 0){
            st.push(x % 10);
            x = x / 10;
        }
        long ans = 0;
        long base = 1;
        while(!st.empty()){
            ans += (long)((int)st.peek() * base);
            base = base * 10;
            st.pop();
        }
        ans = ans * sign;
        if(ans <= Integer.MIN_VALUE || ans > Integer.MAX_VALUE){
            return 0;
        }
        else return (int)ans;
    }
}