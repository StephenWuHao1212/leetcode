/*

	Implement the following operations of a stack using queues.
		push(x) -- Push element x onto stack.
		pop() -- Removes the element on top of the stack.
		top() -- Get the top element.
		empty() -- Return whether the stack is empty.
	Notes:
	You must use only standard operations of a queue -- which means only push to back, peek/pop from front, size, and is empty operations are valid.
	Depending on your language, queue may not be supported natively. You may simulate a queue by using a list or deque (double-ended queue), as long as you use only standard operations of a queue.
	You may assume that all operations are valid (for example, no pop or top operations will be called on an empty stack).
	
*/

import java.util.*;

class MyStack {
    // Push element x onto stack.d
	Queue<Integer> q = new LinkedList<Integer>();
    public void push(int x) {
        if(q.isEmpty()) {
        	q.add(x);
        }
        else{
        	Queue<Integer> tmp = new LinkedList<Integer>();
        	tmp.add(x);
        	while(!q.isEmpty()){
        		tmp.add(q.poll());
        	}
        	q = tmp;
        }
    }

    // Removes the element on top of the stack.
    public void pop() {
        if(!q.isEmpty()) q.poll();
    }

    // Get the top element.
    public int top() {
        if(!q.isEmpty()) return q.peek();
        else return -1;
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return q.isEmpty();
    }
}