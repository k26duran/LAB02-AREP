/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.escuelaing.arem;

/**
 *
 * @author karen duran
 */
public class Node {
	private double data;
	private Node next;
	
	/**Creates a node with the data.
	 * 
	 * @param d it is the data that is the node value.
	 */
	
	public Node(double d) {
		this.data=d;
		this.next=null;
	}

	public double getData() {
		return data;
	}

	public void setData(double data) {
		this.data = data;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}
}