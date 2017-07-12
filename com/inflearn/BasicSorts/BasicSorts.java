package com.inflearn.BasicSorts;

import java.util.Random;

class BasicSorts {
	private int caseNum;
	private int[] array;
	
	public BasicSorts() {
		
	}
	
	public void test(int num) {
		setCaseNum(num);
		
		int i = 0;
		while(i < getCaseNum()) {
			createArray();
			BubbleSort(getArray());
			SelectionSort(getArray());
			InsertionSort(getArray());
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
	
	private void BubbleSort(int[] ary) {
		int c = 0;
		for(int i = ary.length-1; i > 0; i--) {
			for(int j = ary.length-1; j > 0 + c; j--) {
				if(ary[j] < ary[j-1]) {
					int tmp = ary[j];
					ary[j] = ary[j-1];
					ary[j-1] = tmp;
				}
			}
			c++;
		}
		
		System.out.print("The result of Bubble sort is ");
		for(int i = 0; i < ary.length; i++)
		{
			System.out.print(ary[i] + " ");
		}
		System.out.println();
	}
	
	private void SelectionSort(int[] ary) {
		int max, temp, index;
		
		for(int i = 0; i < ary.length; i++) {
			max = ary[0];
			index = 0;
			for(int j = 0; j < ary.length-i; j++) {
				if(max < ary[j]) {
					index = j;
					max = ary[j];
				}
			}
			temp = ary[index];
			ary[index] = ary[ary.length-1-i];
			ary[ary.length-1-i] = temp;
		}
		
		
		System.out.print("The result of Selection sort is ");
		for(int i = 0; i < ary.length; i++)
		{
			System.out.print(ary[i] + " ");
		}
		System.out.println();
	}
	
	private void InsertionSort(int[] ary) {
		
		int temp,save;
		int index = 0;
		
		for(int i = 1; i < ary.length; i++) {
			save = ary[i];
			for(int j = 0; j < i; i++) {
				if(ary[i] < ary[j]) {
					temp = ary[i];
					ary[i] = ary[j];
					ary[j] = temp;
				}
				else {
					index = j;
					break;
				}
				ary[index] = save;
			}
			
		}
		
		
		System.out.print("The result of Insertion sort is ");
		for(int i = 0; i < ary.length; i++)
		{
			System.out.print(ary[i] + " ");
		}
		System.out.println();
	}
}
