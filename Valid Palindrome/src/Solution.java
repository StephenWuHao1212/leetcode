/*
	For example,
	"A man, a plan, a canal: Panama" is a palindrome.
	"race a car" is not a palindrome.
	
	Note:
	Have you consider that the string might be empty? This is a good question to ask during an interview.
	
	For the purpose of this problem, we define empty string as valid palindrome.
	
	
	
	
	if input string is empty, return true
	two pointers, one pointing to the beginning of the string and one pointing to the end of the string
	while the end pointer is behind the front pointer
		while front char is not in alphabetical range(a to z and A to Z)
			front pointer++
		if(front pointer > end pointer) return true
		while end char is not in alphabetical range(a to z and A to Z)
			end pointer--
		if(front pointer > end pointer) return true
		if abs(front - end) equals to 0 or 32
			front pointer++
			end pointer--
		else return false
		
*/

public class Solution {
    public static boolean isPalindrome(String s) {
    	if(s.isEmpty()) return true;
    	int front = 0;
    	int end = s.length() - 1;
    	while(front < end){
    		while(front < s.length() && !(s.charAt(front) >= 'a' && s.charAt(front) <= 'z') && !(s.charAt(front) >= 'A' && s.charAt(front) <= 'Z') && !(s.charAt(front) >= '0' && s.charAt(front) <= '9')){
    			front++;
    		}
    		if(front >= end) return true;
    		while(end > -1 && !(s.charAt(end) >= 'a' && s.charAt(end) <= 'z') && !(s.charAt(end) >= 'A' && s.charAt(end) <= 'Z') && !(s.charAt(end) >= '0' && s.charAt(end) <= '9')){
    			end--;
    		}
    		if(front >= end) return true;
    		int tmp = Math.abs(s.charAt(front) - s.charAt(end));
    		if((s.charAt(front) >= '0' && s.charAt(front) <= '9') && (s.charAt(end) >= '0' && s.charAt(front) <= '9') && tmp == 0){
    			front++;
    			end--;
    		}
    		else if(((s.charAt(front) >= 'a' && s.charAt(front) <= 'z') || (s.charAt(front) >= 'A' && s.charAt(front) <= 'Z')) && ((s.charAt(end) >= 'a' && s.charAt(end) <= 'z') || (s.charAt(end) >= 'A' && s.charAt(end) <= 'Z')) && (tmp == 0 || tmp == 32)){
    			front++;
    			end--;
    		}
    		else return false;
    	}
    	return true;
    }
    
    public static void main(String[] args){
//    	System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
//    	System.out.println(isPalindrome(""));
//    	System.out.println(isPalindrome("a,.,.   ,.,. "));
//    	System.out.println(isPalindrome(",.,.,.,.,.,.,b"));
//    	System.out.println(isPalindrome("adfdewfsdf"));
//    	System.out.println(isPalindrome("bbbaaabbb"));
//    	System.out.println(isPalindrome(",.,/.,/.bbbaa/.././[][]a[][][..,.,.abb[][][][[]]b]][][][]][]"));
//    	System.out.println(isPalindrome("1a2"));
    	System.out.println(isPalindrome("ab2a"));





    }
}