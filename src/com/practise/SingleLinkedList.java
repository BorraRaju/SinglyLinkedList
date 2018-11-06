package com.practise;


public class SingleLinkedList {

	//Creating the node
	Node head;
	
	//inner class
	static class Node{
		int data;
		Node next;
		Node(int d){
			data = d;
			next = null;
		}
	}
	
	//printing the values
	public void printList() {
		Node n = head;
		while(n != null) {
			System.out.print(n.data + " ");
			n = n.next;
		}
	}
	
	//Insert the value in the starting of the LinkedList
	public void push(int new_data) {
		
		Node newNode = new Node(new_data);
		newNode.next = head;
		head = newNode;
		
	}
	
	//insert in the middle of the linked list
	public void insertAfter(Node previous_node, int new_data) {
		
		//Check the previous_node is Null
		if(previous_node == null) {
			System.out.println("The given previous node can not be null");
			return;
		}
		
		//Allocate the Node & put the data
		Node new_node = new Node(new_data);
		
		//Make next of new_node as next of previious_node
		new_node.next = previous_node.next;
		
		//make the next of previous_node as new_node
		previous_node.next = new_node;
		
	}
	
	//Append the new node at the end
	public void append(int new_data) {
		Node new_node = new Node(new_data);
		
		//null checking
		if(head == null) {
			head = new Node(new_data);
			return;
		}
		
		//new node going to be last node
		new_node.next = null;
		
		//Else traverse till the last node
		Node last = head;
		while(last.next != null) {
			last = last.next;
		}
		
		//Change the next node of last node
		last.next = new_node;
		return;
	}
	
	
	//deleting a node
	//delete the first occurance of key in the linkedList
	void delete(int key) {
		
		//Store head node
		Node temp = head, prev = null;
		
		//If head node itself holds the key to be deleted 
		if(temp != null && temp.data == key) {
			head = temp.next; //Changed head
			return;
		}
		
		//Search for the key to be deleted, keep track of the previous node
		// as we need to change temp.next
		while(temp != null && temp.data !=key) {
			prev = temp;
			temp = temp.next;
		}
		
		//If the key not present in the list
		if(temp == null) return;
		
		//Unlink the node from Linked list
		prev.next = temp.next;
	}
	
	public static void main(String args[]) {
		SingleLinkedList list = new SingleLinkedList();
		list.head = new Node(1);
		Node second = new Node(2);
		Node third = new Node(3);
		
		list.head.next = second;
		
		second.next = third;
		
		//insert the value in start
		list.push(5);
		
		//insert the value in middle	
		list.insertAfter(second,7);
		
		//append value at last
		list.append(24);
		
		list.printList();
	}
}
