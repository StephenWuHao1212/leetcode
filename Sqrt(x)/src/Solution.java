/*
	Implement int sqrt(int x).

	Compute and return the square mid of x.
	
	
*/

public class Solution {
    public static int mySqrt(int x) {
    	if(x < 2) return x;
    	double left = 0;
    	double mid = x/2;
    	double right = x;
    	while(true){
    		if(mid * mid <= x && (mid + 1) * (mid + 1) > x) return (int)mid;
    		else if(mid * mid <= x && (mid + 1) * (mid + 1) <= x) {
    			left = mid;
    			mid = (right + mid ) / 2;
    		}
    		else if(mid * mid > x) {
    			right = mid;
    			mid = (int)(mid + left) / 2;
    		}
    	}
    }
    
    public static void main(String[] args){
    	System.out.println(mySqrt(0));
    	System.out.println(mySqrt(1));
    	System.out.println(mySqrt(6));
    	System.out.println(mySqrt(4));
    	System.out.println(mySqrt(2147395599));


    }
}