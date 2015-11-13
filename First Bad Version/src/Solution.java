/*
	You are a product manager and currently leading a team to develop a new product. 
	Unfortunately, the latest version of your product fails the quality check. 
	Since each version is developed based on the previous version, all the versions after a bad version are also bad.

	Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.

	You are given an API bool isBadVersion(version) which will return whether version is bad. 
	Implement a function to find the first bad version. You should minimize the number of calls to the API.


	
	if the first one is bad, return 1
	
	int helper(first, second)
		- if second - first = 1
			- return second
		- len = second -first + 1
		- if len is odd
			- mid = (second + first) / 2
			- if mid is great
				- return helper(mid, second)
			- else
				- return helper(first, mid)
		- else
			mid1 = (second + first) / 2
			mid2 = mid1 + 1
			if mid1 is great and mid2 is bad
				return mid1
			else if mid1 is great and mid2 is great
				return helper(mid2, second)
			else
				return helper(first, mid1)
				
*/

/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        if(isBadVersion(1)) return 1;
        if(!isBadVersion(n)) return n + 1;
        return helper(1, n);
    }
    
    public int helper(int p1, int p2){
    	if(p2 - p1 == 1) return p2;
    	int len = p2 - p1 + 1;
    	if(len % 2 != 1){
    		int mid = (p1 + p2) / 2;
    		boolean t = isBadVersion(mid);
    		if(!t) return helper(mid, p2);
    		else return helper(p1, mid);
    	}
    	else{
    		int mid1 = (p1 + p2) / 2;
    		int mid2 = mid1 + 1;
    		boolean t1 = isBadVersion(mid1);
    		boolean t2 = isBadVersion(mid2);
    		if(!t1 && t2) return mid1;
    		else if(!t1 && !t2) return helper(mid2, p2);
    		else return helper(p1, mid1);
    	}
    }
}






