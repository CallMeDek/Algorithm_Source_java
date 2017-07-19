package com.inflearn.HeapSort;

import com.inflearn.HeapSort.HeapSort;
import java.util.Random;

public class HeapSort_test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int testCase = new Random().nextInt(5)+1;
		HeapSort a = new HeapSort();
		a.test(testCase);
	}

}
