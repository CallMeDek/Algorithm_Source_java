package com.inflearn.RadixSort;

import java.util.Random;
import com.inflearn.RadixSort.RadixSort;

public class RadixSort_test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int testCase = new Random().nextInt(6)+5;
		RadixSort a = new RadixSort();
		a.test(testCase);
	}

}
