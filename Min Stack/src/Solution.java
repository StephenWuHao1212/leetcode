/*
	Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

	push(x) -- Push element x onto stack.
	pop() -- Removes the element on top of the stack.
	top() -- Get the top element.
	getMin() -- Retrieve the minimum element in the stack.

 */


/*
	use a singly-linked list with root which is the first node of the list
	set an indicator to represent the current minimum value of the stack when it is the head
	push
		- put a new node to the head
		- determine the min of the node
	pop
		- pop up the head
	top
		- return head
	getMin
		- return head.min
 */

class Stack {
	static class MinStack {
		class StackNode {
			int val;
			int min;
			StackNode next;
			StackNode(int x, int y) {
				val = x;
				min = y;
			}
		}

		StackNode root;
		MinStack() {
			root = null;
		}
		
		public void print(){
			String ans = new String();
			if(root != null){
				StackNode curr = root;
				while(curr != null){
					ans += curr.val;
					ans += " ";
					curr = curr.next;
				}
			}
			System.out.println(ans);
		}
		
		public void push(int x) {
			if(root == null) {
				StackNode newNode = new StackNode(x, x);
				root = newNode;
			}
			else{
				StackNode newNode = new StackNode(x, Math.min(x, root.min));
				newNode.next = root;
				root = newNode;
			}
		}

		public void pop() {
			if(root != null)
				root = root.next;
		}

		public int top() {
			if(root == null) return -1;
			else return root.val;
		}

		public int getMin() {
			if(root != null)
				return root.min;
			else
				return -1;
		}

	}
	
	public static void main(String args[]){
		MinStack test = new MinStack();
		test.push(1);
		test.push(2);
		test.push(3);
		test.push(1);
		test.push(-1);
		test.push(-10);
		test.push(-100);
		test.push(100);
		test.push(1000);
		test.pop();
		System.out.println(test.top());
		System.out.println(test.getMin());

		test.print();
	}
}





