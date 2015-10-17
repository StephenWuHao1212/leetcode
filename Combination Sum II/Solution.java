/*
	Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

	Each number in C may only be used once in the combination.

	Note:
	All numbers (including target) will be positive integers.
	Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
	The solution set must not contain duplicate combinations.
	For example, given candidate set 10,1,2,7,6,1,5 and target 8, 
	A solution set is: 
	[1, 7] 
	[1, 2, 5] 
	[2, 6] 
	[1, 1, 6] 
*/

public class Solution {
    public class data{
        int val;
        int index;
        public data(int value, int i){
            val = value; 
            index = i;
        }
    }
    
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        int len = candidates.length;
        List<List<Integer>> ans = new LinkedList<List<Integer>>();
        if(len == 0) return ans;
        Stack<data> stack = new Stack<data>();
        Arrays.sort(candidates);
        int start = 0; int curr = 0; int count = 0;
        while(true){
            if(stack.empty() && start >= len) break;
            while(start < len && candidates[start] == curr) start++;
            if(start < len){
                data tmp = new data(candidates[start], start);
                stack.push(tmp);
                count += candidates[start];
                start++;
            }
            if(count >= target){
                if(count == target){
                    Stack<data> newOne = (Stack<data>)stack.clone();
                    ans.add(toList(newOne));
                }
                if(stack.size() > 1){
                    curr = stack.peek().val;
                    start = stack.peek().index + 1;
                    count -= curr;
                    stack.pop();
                    curr = stack.peek().val;
                    start = stack.peek().index + 1;
                    count -= curr;
                    stack.pop();
                }
                else if(stack.size() == 1){
                    curr = stack.peek().val;
                    start = stack.peek().index + 1;
                    count -= curr;
                    stack.pop();
                }
                while(start < len && candidates[start] == curr) start++;
            }
            else if(count < target){
                if(start >= len){
                    
                    if(stack.size() >= 1){
                        curr = stack.peek().val;
                        start = stack.peek().index + 1;
                        count -= curr;
                        stack.pop();
                    }
                }
            }
        }
        return ans;
    }
    
    public LinkedList<Integer> toList(Stack<data> stack){
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