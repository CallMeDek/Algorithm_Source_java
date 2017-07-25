package com.inflearn.BinaryTree;

import java.awt.print.Printable;

import com.inflearn.Setting;


class Queue{
	private int[] queue;
	private int front = -1;
	private int rear = front;
	
	Queue(int len) {
		// TODO Auto-generated constructor stub
		queue = new int[len];
	}
	
	boolean empty() {
		if(front == rear) return true;
		else return false;
	}
	
	private boolean full() {
		if(front == queue.length-1) return true;
		else return false;
	}
	
	void enqueue(int element) {
		if(full()) return;
		front++;
		queue[front] = element;
	}
	
	int dequeue() {
		if(empty()) return -1;
		rear++;
		return queue[rear];
	}
}

public class BinaryTree {
	
	Queue myqueue;
	
	public BinaryTree() {}
	
	public void test(int num) {
		Setting.setCaseNum(num);
		
		int i = 0;
		while(i < Setting.getCaseNum()) {
			Setting.createArray();
			Setting.printAry();
			inorderTraversal(Setting.getArray(), 0);
			System.out.println();
			preorderTraversal(Setting.getArray(), 0);
			System.out.println();
			postorderTraversal(Setting.getArray(), 0);
			System.out.println();
			levelorderTraversal(Setting.getArray());
			System.out.println();
			System.out.println((i+1) + " test has done.");
			System.out.println();
			i++;
		}
	}
	
	private void inorderTraversal(int[] ary, int node) {
		if(node == 0) { 
			buildMinHeap(ary);
			System.out.print("Heapified array : ");
			Setting.printAry();
			System.out.print("Inorder Path is : ");
		}
		if(node > ary.length-1) return;
		else {
			inorderTraversal(ary, 2*node+1);
			System.out.print(ary[node] + " ");
			inorderTraversal(ary, 2*node+2);
		}
	}
	
	private void preorderTraversal(int[] ary, int node) {
		if(node == 0) { 
			buildMinHeap(ary);
			System.out.print("Heapified array : ");
			Setting.printAry();
			System.out.print("Preorder Path is : ");
		}
		if(node > ary.length-1) return;
		else {
			System.out.print(ary[node] + " ");
			preorderTraversal(ary, 2*node+1);
			preorderTraversal(ary, 2*node+2);
		}
	}
	
	private void postorderTraversal(int[] ary, int node) {
		if(node == 0) { 
			buildMinHeap(ary);
			System.out.print("Heapified array : ");
			Setting.printAry();
			System.out.print("Postorder Path is : ");
		}
		if(node > ary.length-1) return;
		else {
			postorderTraversal(ary, 2*node+1);
			postorderTraversal(ary, 2*node+2);
			System.out.print(ary[node] + " ");
		}
	}
	
	
	
	private void levelorderTraversal(int[] ary) {
		buildMinHeap(ary);
		System.out.print("Heapified array : ");
		Setting.printAry();
		System.out.print("Levelorderorder Path is : ");
		
		myqueue = new Queue(ary.length);
		myqueue.enqueue(0);
		
		int node;
		while(!myqueue.empty()) {
			node = myqueue.dequeue();
			System.out.print(ary[node] + " ");
			if(2*node+1 <= ary.length-1) myqueue.enqueue(2*node+1);
			if(2*node+2 <= ary.length-1) myqueue.enqueue(2*node+2);
		}
	}
	
	private void minHeapify(int[] ary, int node) {
		int temp, k;
		
		if(2*node+1 > ary.length-1) return;
		else if(2*node+1 == ary.length-1) {
			if(ary[2*node+1] < ary[node]) {
				temp = ary[2*node+1];
				ary[2*node+1] = ary[node];
				ary[node] = temp;
			}
			return;
		}
		else {
			while(2*node+1 <= ary.length-1) {
				if(2*node+2 > ary.length-1) {
					if(ary[2*node+1] < ary[node]) {
						temp = ary[2*node+1];
						ary[2*node+1] = ary[node];
						ary[node] = temp;
					}
					break;
				}
				if(ary[2*node+1] < ary[2*node+2]) k = 2*node+1;
				else k = 2*node+2;
				if(ary[node] > ary[k]) {
					temp = ary[node];
					ary[node] =ary[k];
					ary[k] = temp;
				}
				node = k;
			}
		}
	}
	
	private void buildMinHeap(int[] ary) {
		for(int i = (ary.length-1)/2; i >= 0; i--)
			minHeapify(ary, i);
	}
}
