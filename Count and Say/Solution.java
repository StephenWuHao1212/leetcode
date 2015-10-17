/*
	The count-and-say sequence is the sequence of integers beginning as follows:
	1, 11, 21, 1211, 111221, ...

	1 is read off as "one 1" or 11.
	11 is read off as "two 1s" or 21.
	21 is read off as "one 2, then one 1" or 1211.
	Given an integer n, generate the nth sequence.

	Note: The sequence of integers will be represented as a string.
*/

public class Solution {
    public String countAndSay(int n) {
        String num = Integer.toString(1);
        int tmp = 0;
        LinkedList<String> ans = new LinkedList<String>();
        ans.add(num);
        int k = 0;
        while(true){
            if(n == 1) return Integer.toString(1);
            String curr = ans.get(k);
            String currAns = new String();
            for(int i = 0; i < curr.length(); i++){
                if(i == 0) tmp = Integer.parseInt(curr.substring(i, i + 1)) + 10;
                else if(curr.charAt(i) == curr.charAt(i - 1)) tmp += 10;
                else{
                    currAns += Integer.toString(tmp);
                    tmp = Integer.parseInt(curr.substring(i, i + 1)) + 10;
                }
            }
            currAns += Integer.toString(tmp);
            ans.add(currAns);
            if(ans.size() > n) return ans.get(n - 1);
            k++;
        }
    }
}