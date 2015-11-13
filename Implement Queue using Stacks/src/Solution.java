/*

	Implement the following operations of a queue using stacks.

	push(x) -- Push element x to the back of queue.
	pop() -- Removes the element from in front of queue.
	peek() -- Get the front element.
	empty() -- Return whether the queue is empty.
	Notes:
	You must use only standard operations of a stack -- which means only push to top, peek/pop from top, size, and is empty operations are valid.
	Depending on your language, stack may not be supported natively. You may simulate a stack by using a list or deque (double-ended queue), 
	as long as you use only standard operations of a stack.
	You may assume that all operations are valid (for example, no pop or peek operations will be called on an empty queue).
 */

import java.util.*;
class MyQueue {
	   Stack<Integer> s = new Stack<Integer>();
		// Push element x to the back of queue.
		public void push(int x) {
			if(s.isEmpty()) s.add(x);
			else {
				int[] a = new int[s.size()];
				int len = s.size();
				for(int i = 0; i < len; i++){
					a[i] = s.pop();
				}
				s.add(x);
				for(int i = len - 1; i > -1; i--){
					s.add(a[i]);
				}
			}
		}

		// Removes the element from in front of queue.
		public void pop() {
			if(!s.isEmpty()) s.pop();
		}

		// Get the front element.
		public int peek() {
			if(s.isEmpty()) return -1;
			else return s.peek();
		}

		// Return whether the queue is empty.
		public boolean empty() {
			return s.isEmpty();
		}
	}