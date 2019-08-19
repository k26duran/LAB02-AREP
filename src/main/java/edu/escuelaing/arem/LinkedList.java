/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.escuelaing.arem;

/**
 *
 * @author fduran
 */
public class LinkedList {
        
        private Node head;
	
	public LinkedList() {
		this.head=null;
	}
	
	/** Method to insert a new node 
	 * @param list linkedList
	 * @param data data to insert
	 * @return the modified list**/ 
	public LinkedList insert(LinkedList list, double data) 
	{ 
		Node newnode = new Node(data); 
		newnode.setNext(null); 
		if (list.head == null) { 
			list.head = newnode; 
		} 
		else { 
			Node last = list.head; 
			while (last.getNext() != null) { 
				last = last.getNext(); 
			} 
			last.setNext(newnode); 
		} 
		return list; 
	} 

	/** Method to print the LinkedList. 
	 * @param list linkedList to print**/ 
	public void printList(LinkedList list) 
	{ 
		Node actualNode = list.head; 
		System.out.print("\nLinkedList: "); 
		while (actualNode != null) { 
			System.out.print(actualNode.getData() + " "); 
			actualNode = actualNode.getNext(); 
		} 
		System.out.println("\n"); 
	}
	
	public Node getHead() {
		return this.head;
	}

}
