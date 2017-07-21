package com.inflearn.CountingSort;

import java.util.Random;

public class CountingSort {
	private int testNum;
	private int[] testArray;
	
	public CountingSort() {}
	
	public void test(int num) {
		
		int i;
		testNum = num;
		
		i = 0;
		while(i < testNum) {
			createArray();
			printArray();
			countingSort(testArray);
			System.out.println();
			printArray();
			System.out.println();
			System.out.println((i+1)+"번째 테스트 완료.");
			System.out.println();
			i++;
		}
	}
	
	private void createArray() {
		testArray = new int[new Random().nextInt(10)+1];
		for(int i = 0; i < testArray.length; i++)
			testArray[i] = new Random().nextInt(10)+1;
	}
	
	private void printArray() {
		for(int i = 0; i < testArray.length; i++)
			System.out.print(testArray[i] + " ");
	}
	
	private void countingSort(int[] ary) {
		int i, max = 0;
		int[] countAry;
		int[] accumulateAry;
		int[] temp;
		
		for(i = 0; i < ary.length; i++) {
			max = Math.max(max, ary[i]);
		}
		
		countAry = new int[max];
		accumulateAry = new int[countAry.length];
		
		for(i = 0; i < countAry.length; i++)
			countAry[i] = 0;
		
		for(i = 0; i < ary.length; i++)
			countAry[ary[i]-1]++;
		
		for(i = 0; i < countAry.length; i++) {
			if(i == 0) accumulateAry[0] = countAry[0];
			else accumulateAry[i] = countAry[i] + accumulateAry[i-1];
		}
			
		temp = new int[ary.length];
		for(i = 0; i < ary.length; i++) {
			temp[accumulateAry[ary[i]-1]-1] = ary[i];
			accumulateAry[ary[i]-1]--;
		}
		
		
		for(i = 0; i < temp.length; i++)
			ary[i] = temp[i];
	
	}
	
}
