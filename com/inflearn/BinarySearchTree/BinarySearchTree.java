package com.inflearn.BinarySearchTree;

import com.inflearn.*;
import java.util.Random;

class Node{
	Node left;
	Node right;
	Node parent;
	int data;
	
	Node(){
		left = null;
		right = null;
		parent = null;
	}
	
	Node(int data){
		left = null;
		right = null;
		parent = null;
		this.data = data;
	}

	Node getLeft() {
		return left;
	}

	void setLeft(Node left) {
		this.left = left;
	}

	Node getRight() {
		return right;
	}

	void setRight(Node right) {
		this.right = right;
	}

	int getData() {
		return data;
	}

	Node getParent() {
		return parent;
	}

	void setParent(Node parent) {
		this.parent = parent;
	}
	
	
}

public class BinarySearchTree {
	
	Node root;
	
	public BinarySearchTree() {}
	public void test(int num) {
		
		Setting.setCaseNum(num);
		
		int i = 1;
		while(i < Setting.getCaseNum()+1) {
			createRoot();
			Setting.createArray();
			Setting.printAry();
			buildBTS(Setting.getArray());
			inorderTraversal(getRoot());
			System.out.println();
			testSearch();
			System.out.println();
			getMaxOrMin(getRoot());
			System.out.println();
			successorTest(Setting.getArray());
			predecessorTest(Setting.getArray());
			System.out.println();
			anotherInsertTest();
			System.out.println();
			deleteTest(Setting.getArray());
			System.out.println();
			System.out.println(i + " test just has done.");
			System.out.println();
			i++;
		}
	}
	
	private void createRoot() {
		root = null;
	}
	
	private void setRoot(Node root) {
		this.root = root;
	}
	
	private Node getRoot() {
		return this.root;
	}
	
	private Node insertNode(Node root, int data) {
		Node newNode = new Node(data);
		
		if(root == null) return newNode;
		if(root.getData() > newNode.getData()) {
			root.left = insertNode(root.left, data);
			root.left.setParent(root);
			return root;
		}
		else if(root.getData() <= newNode.getData()) {
			root.right = insertNode(root.right, data);
			root.right.setParent(root);
			return root;
		} 
		else return root;
	}
	
	private void buildBTS(int[] dataArray) {
		for(int i = 0; i < dataArray.length; i++)
			setRoot(insertNode(root, dataArray[i]));
	}
	
	private void inorderTraversal(Node node) {
		if(node == null) {
			return;
		}
		else {
			inorderTraversal(node.getLeft());
			System.out.print(node.getData() + " ");
			inorderTraversal(node.getRight());
		}
	}
	
	private void preorderTraversal(Node node) {
		if(node == null) {
			return;
		}
		else {
			System.out.print(node.getData() + " ");
			inorderTraversal(node.getLeft());
			inorderTraversal(node.getRight());
		}
	}
	
	private void testSearch() {
		int radix = 1;
		Node result = null;
		Node test = new Node(new Random().nextInt(9)+radix);
		System.out.println("The data of node who we wanna look for is " + test.getData());
		result = searchNode(getRoot(), test);
		if(result != null) {
			System.out.println("Yes we've found it!");
		} else System.out.println("No It isn't here...");
		for(int i = 1; i <=9; i++) {
			test = new Node(new Random().nextInt(9)+radix + (i*10));
			System.out.println("The data of node who we wanna look for is " + test.getData());
			result = searchNode(getRoot(), test);
			if(result != null) {
				System.out.println("Yes we've found it!");
			} else System.out.println("No It isn't here...");
		}
	}
	
	private Node searchNode(Node compare, Node node) {
		if(node == null || compare ==null) return null;
		else {
			Node find;
			if(compare.getData() == node.getData()) return compare;
			else if(compare.getData() > node.getData()) {
				find = searchNode(compare.getLeft(), node);
				return find;
			}
			else {
				find = searchNode(compare.getRight(), node);
				return find;
			}
		}
	}
	
	private void getMaxOrMin(Node root) {
		System.out.println("The min value is " + getMin(root).getData());
		System.out.println("The max value is " + getMax(root).getData());
	}
	
	private Node getMin(Node root) {
		if(root.getLeft() == null) return root;
		else return getMin(root.getLeft());
	}
	
	private Node getMax(Node root) {
		if(root.getRight() == null) return root;
		else return getMax(root.getRight());
	}
	
	private void successorTest(int[] ary) {
		Node temp = new Node(ary[new Random().nextInt(ary.length)]);
		Node target = searchNode(getRoot(), temp);
		Node succeesor = successor(target);
		try {
			if(succeesor.getData() == target.getData()) {
				System.out.println("There is no successor of " + target.getData());
				return;
			}
			System.out.println(target.getData() + "'s successor is " + succeesor.getData());
		} catch (NullPointerException e) {
			System.out.println("There is no successor of " + target.getData());
		}
	}
	
	private Node successor(Node node) {
		if(node.getRight() != null) {
			return getMin(node.getRight());
		}
		else {
			
			while(node.getParent() != null && node == node.getParent().getRight()) {
				node = node.getParent();
			}
			return node.getParent();
		}
	}
	
	private void predecessorTest(int[] ary) {
		Node temp = new Node(ary[new Random().nextInt(ary.length)]);
		Node target = searchNode(getRoot(), temp);
		Node predecessor = predecessor(target);
		try {
			if(predecessor.getData() == target.getData()) {
				System.out.println("There is no predecessor of " + target.getData());
				return;
			}
			System.out.println(target.getData() + "'s predecessor is " + predecessor.getData());
		} catch (NullPointerException e) {
			System.out.println("There is no predecessor of " + target.getData());
		}
	}
	
	private Node predecessor(Node node) {
		if(node.getLeft() != null) {
			return getMax(node.getLeft());
		}
		else {
			
			while(node.getParent() != null && node == node.getParent().getLeft()) {
				node = node.getParent();
			}
			return node.getParent();
		}
	}
	
	private void anotherInsertTest() {
		int number = new Random().nextInt(99)+1;
		System.out.println("The insert number is " + number);
		Node newNode = new Node(number);
		insertNodeIteration(getRoot(), newNode);
		System.out.print("The result : ");
		inorderTraversal(getRoot());
		addElementInToArray(Setting.getArray(), number);
	}
	
	private void insertNodeIteration(Node root, Node node) {
		Node follow = null;
		Node r = root;
		while(r != null) {
			follow = r;
			if(r.getData() > node.getData()) {
				r = r.getLeft();
			} else r = r.getRight();
		}
		node.setParent(follow);
		if(follow == null) {
			setRoot(node);
		}
		else {
			if(follow.getData() > node.getData()) follow.setLeft(node);
			else follow.setRight(node);
		}
	}
	
	private void addElementInToArray(int[] ary, int element) {
		int[] temp = new int[ary.length+1];
		for(int i = 0; i < ary.length; i++)
			temp[i] = ary[i];
		temp[ary.length] = element;
		ary = temp;
	}
	
	private void deleteNode(Node root, Node node) {
		if(root == null) { 
			return;
		}
		// this case should be fixed.
		if(node == root && (node.getLeft() == null || node.getRight() == null)) {
			if(node.getLeft() == null)
				setRoot(successor(node));
			else if(node.getRight() == null)
				setRoot(predecessor(node));
			return;
		}
		if(node.getLeft() == null && node.getRight() == null) {
			if(node == node.getParent().getLeft()) node.getParent().setLeft(null);
			else if (node == node.getParent().getRight()) node.getParent().setRight(null);
			node = null;
			return;
		}
		else if(node.getLeft() != null && node.getRight() == null) {
			node.getLeft().setParent(node.getParent());
			if(node == node.getParent().getLeft()) {
				node.getParent().setLeft(node.getLeft());
			} else {
				node.getParent().setRight(node.getLeft());
			}
			node = null;
			return;
		}
		else if(node.getLeft() == null && node.getRight() != null) {
			node.getRight().setParent(node.getParent());
			if(node == node.getParent().getLeft()) {
				node.getParent().setLeft(node.getRight());
			} else {
				node.getParent().setRight(node.getRight());
			}
			node = null;
			return;
		}
		else {
			Node predecessor = predecessor(node);
			node.data = predecessor.getData();
			if(predecessor.getLeft() == null) {
				if(predecessor == predecessor.getParent().getLeft()) {
					predecessor.getParent().setLeft(null);
				} else if ( predecessor == predecessor.getParent().getRight()) {
					predecessor.getParent().setRight(null);
				}
				predecessor = null;
			}
			else {
				predecessor.getLeft().setParent(predecessor.getParent());
				predecessor.getParent().setRight(predecessor.getLeft());
				predecessor = null;
			}
			
		}
	}
	
	private void deleteTest(int[] ary) {
		int value = ary[new Random().nextInt(ary.length)];
		System.out.println("The number which will be eliminated is " + value);
		Node temp = new Node(value);
		Node target = searchNode(getRoot(), temp);
		deleteNode(getRoot(), target);
		System.out.print("The result : ");
		inorderTraversal(getRoot());
		subtractElementFromArray(ary, value);
	}
	
	private void subtractElementFromArray(int[] ary, int element) {
		int[] temp = new int[ary.length-1];
		int index = 0;
		for(int i = 0; i < ary.length; i++) {
			if(ary[i] == element) index = i;
		}
		int j = 0;
		for(int i = 0; i < temp.length; i++) {
			if(j == index) continue;
			temp[i] = ary[j++];
		}
		
		ary = temp;
	}
}
