/*
	Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

	The same repeated number may be chosen from C unlimited number of times.

	Note:
	All numbers (including target) will be positive integers.
	Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
	The solution set must not contain duplicate combinations.
	For example, given candidate set 2,3,6,7 and target 7, 
	A solution set is: 
	[7] 
	[2, 2, 3] 
*/

public class Solution {
    public class data{
        int val;
        int index;
        public data(int value, int i){
            val = value; index = i;
        }
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new LinkedList<List<Integer>>();
        int len = candidates.length;
        if(len == 0) return ans;
        Arrays.sort(candidates);
        Stack<data> stack = new Stack<data>();
        for(int i = 0; i < len; i++){
            int start = i; int count = 0;
            if(candidates[start] > target) return ans;
            stack.clear();
            while(true){
                if(start >= len){
                    if(stack.size() <= 1) break;
                    else {
                        count = count - (int)stack.peek().val;
                        start = (int)stack.peek().index;
                        stack.pop();
                        start++;
                    }
                }
                else{
                    count += candidates[start];
                    if(count < target) {
                        data tmp = new data(candidates[start], start);
                        stack.push(tmp);
                    }
                    else if(count == target){
                        Stack<data> newOne = (Stack<data>)stack.clone();
                        data tmp = new data(candidates[start], start);
                        newOne.push(tmp);
                        ans.add(addToList(newOne));
                        count -= candidates[start];
                        start++;
                    }
                    else{
                        count -= candidates[start];
                        if(stack.size() > 1){
                            count = count - (int)stack.peek().val;
                            start = (int)stack.peek().index;
                            stack.pop();
                        }
                        start++;
                    }
                }
            }
        }
        return ans;
    }
    
    public LinkedList<Integer> addToList(Stack<data> stack){
        LinkedList<Integer> ans = new LinkedList<Integer>();
        int[] array = new int[stack.size()];
        int i = 0;
        while(!stack.empty()){
            array[i] = (int)stack.peek().val;
            stack.pop();
            i++;
        }
        Arrays.sort(array);
        for(i = 0; i < array.length; i++){
            ans.add(array[i]);
        }
        return ans;
    }
}