package com.inflearn.QuickSort;

import java.util.Random;

class QuickSort {
	private int caseNum;
	private int[] array;
	
	public QuickSort() {
		
	}
	
	public void test(int num) {
		setCaseNum(num);
		
		int i = 0;
		while(i < getCaseNum()) {
			createArray();
			printAry();
			System.out.println();
			quickSort(getArray(),0,getArray().length-1);
			printAry();
			System.out.println((i+1) + " test is done.");
			System.out.println();
			i++;
		}
	}
	
	private void setCaseNum(int num) {
		caseNum = num;
	}
	
	private int getCaseNum() {
		return caseNum;
	}
	
	private void createArray() {
		
		Random rand = new Random();
		
		int size = rand.nextInt(10)+2;
		array = new int[size];
		for(int i = 0; i < size; i++)
		{
			array[i] = rand.nextInt(100);
		}
	}
	
	private int[] getArray() {
		return array;
	}
	
	private void quickSort(int[] ary, int begin, int end) {
		if(begin < end) {
			int q = partition(ary, begin, end);
			quickSort(ary, begin, q-1);
			quickSort(ary, q+1, end);
		}
	}
	
	private int partition(int[] ary, int begin, int end) {
		int value = ary[end];
		int i = begin -1, temp = 0;
		for(int k = begin; k <= end; k++) {
			if(ary[k] < value) {
				i++;
				temp = ary[i];
				ary[i] = ary[k];
				ary[k] = temp;
			}
		}
		i++;
		temp = ary[i];
		ary[i] = value;
		ary[end] = temp;
		return i;
	}
	
	private void printAry() {
		for(int i = 0; i < array.length; i++)
			System.out.print(array[i] + " ");
		System.out.println();
	}
}
