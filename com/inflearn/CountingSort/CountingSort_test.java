package com.inflearn.CountingSort;

import java.util.Scanner;
import com.inflearn.CountingSort.CountingSort;

public class CountingSort_test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.print("Insert the number of the test>>");
		int testCase = scan.nextInt();
		CountingSort a = new CountingSort();
		a.test(testCase);
	}

}
