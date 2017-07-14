package com.inflearn.MergeSort;

import com.inflearn.MergeSort.MergeSort;
import java.util.Random;

public class MergeSort_test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int testCase = new Random().nextInt(5)+1;
		
		MergeSort a = new MergeSort();
		a.test(testCase);
	}

}
