/*

	Count the number of prime numbers less than a non-negative number, n
	
	
	
	
	we only need to consider factors up to √n because, if n is divisible by some number p, 
	then n = p × q and since p ≤ q, we could derive that p ≤ √n.
	
	The Sieve of Eratosthenes is one of the most efficient ways to find all prime numbers up to n. But don't let that name scare you, I promise that the concept is surprisingly simple.


Sieve of Eratosthenes: algorithm steps for primes below 121. 
"Sieve of Eratosthenes Animation" by SKopp is licensed under CC BY 2.0.

We start off with a table of n numbers. Let's look at the first number, 
2. We know all multiples of 2 must not be primes, so we mark them off as non-primes. 
Then we look at the next number, 3. Similarly, all multiples of 3 such as 3 × 2 = 6, 3 × 3 = 9, ... 
must not be primes, so we mark them off as well. Now we look at the next number, 4, 
which was already marked off. What does this tell you? Should you mark off all multiples of 4 as well?

4 is not a prime because it is divisible by 2, which means all multiples of 4 must also be divisible by 2 and were already marked off. So we can skip 4 immediately and go to the next number, 5. Now, all multiples of 5 such as 5 × 2 = 10, 5 × 3 = 15, 5 × 4 = 20, 5 × 5 = 25, ... can be marked off. There is a slight optimization here, we do not need to start from 5 × 2 = 10. Where should we start marking off?

In fact, we can mark off multiples of 5 starting at 5 × 5 = 25, because 5 × 2 = 10 was already marked off by multiple of 2, similarly 5 × 3 = 15 was already marked off by multiple of 3. Therefore, if the current number is p, we can always mark off multiples of p starting at p2, then in increments of p: p2 + p, p2 + 2p, ... Now what should be the terminating loop condition?

It is easy to say that the terminating loop condition is p < n, which is certainly correct but not efficient. Do you still remember Hint #3?

Yes, the terminating loop condition can be p < √n, as all non-primes ≥ √n must have already been marked off. When the loop terminates, all the numbers in the table that are non-marked are prime.
*/

public class Solution {
    public int countPrimes(int n) {
    	int ans = 0;
    	boolean isPrime[] = new boolean[n];
    	for(int i = 0; i < n; i++){
    		isPrime[i] = true;
    	}
    	for(int i = 2; i * i <= n; i++){
    		if(!isPrime[i]) continue;
    		for(int j = i * i; j < n; j += i){
    			isPrime[j] = false;
    		}
      	}
    	for(int i = 0; i < n; i++){
    		if(isPrime[i]) ans++;
    	}
    	return ans;
    	
    }
}