/*
	You are climbing a stair case. It takes n steps to reach to the top.
	Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
	
	like solving a fibonnaci sequence problem
*/

public class Solution{
	public static void main(String[] args){
		System.out.println(climbStairs(5));
	}
	public static int climbStairs(int n){
		if (n < 4) return n;
		int a = 2, b = 3, c = 5;
		for (int i = 5; i <= n; i++)
		{
			a = c;
			c = b+c;
			b = a;
		}
		return c;
	}
}