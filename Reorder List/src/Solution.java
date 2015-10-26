/*
	Given a singly linked list L: L0→L1→…→Ln-1→Ln,
	reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

	You must do this in-place without altering the nodes' values.

	For example,
	Given {1,2,3,4}, reorder it to {1,4,2,3}.
	
	Solution: 
	- fast and slow to find the middle point of the list
	- reverse the second part of the list
	- merge both parts to get the answer 
	
*/