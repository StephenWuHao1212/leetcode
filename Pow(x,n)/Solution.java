/*
	Implement pow(x, n).
*/

public class Solution {
    public double myPow(double x, int n) {
        if(x == 0) return 0;
        if(n == 0) return 1;
        else if(n == 1) return x;
        else if(n == 2) return x*x;
        else if(n == -1) return 1 / x;
        else if(n == -2) return 1 / (x * x);
        else if(Math.abs(n % 2) == 1) return myPow(myPow(x, n / 2),2) * (n < 0?1/x:x);
        else if(Math.abs(n % 2) == 0) return myPow(myPow(x, n / 2),2);
        return 0;
    }
}