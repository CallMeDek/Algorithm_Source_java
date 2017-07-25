package com.inflearn.BinaryTree;

import java.util.Random;
import com.inflearn.BinaryTree.BinaryTree;

public class BinaryTree_test {
	
	public static void main(String args[]) {
		int testCase = new Random().nextInt(5)+5;
		BinaryTree a = new BinaryTree();
		a.test(testCase);
	}
}

