package com.inflearn.QuickSort;

import java.util.Random;

import com.inflearn.QuickSort.QuickSort;

public class QuickSort_test {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int testCase = new Random().nextInt(5)+1;
		
		QuickSort a = new QuickSort();
		a.test(testCase);
	}
}
