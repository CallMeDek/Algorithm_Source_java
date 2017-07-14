package com.inflearn.MergeSort;

import java.util.Random;

class MergeSort {
	private int caseNum;
	private int[] array;
	
	public MergeSort() {
		
	}
	
	public void test(int num) {
		setCaseNum(num);
		
		int i = 0;
		while(i < getCaseNum()) {
			createArray();
			printAry();
			mergeSort(getArray(), 0, getArray().length-1);
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
	
	private void mergeSort(int[] ary, int begin, int end) {
		if( begin < end) {
			int middle = (begin + end) / 2;
			mergeSort(ary, begin, middle);
			mergeSort(ary, middle+1, end);
			merge(ary, begin, middle, end);
		}
	}
	
	private void merge(int[] data, int begin, int middle, int end) {
		
		int[] temp = new int[data.length];
		int k = begin;
		int i = begin, j = middle+1;
		
		while(i <= middle && j <= end) {
			if(data[i] < data[j]) {
				temp[k] = data[i];
				k++; i++;
			}
			else {  
				temp[k] = data[j];
				k++; j++;
			}
		}
		while(i <= middle) {
			temp[k] = data[i];
			k++; i++;
		}
		while(j <= end) {
			temp[k] = data[j];
			k++; j++;
		}
		
		for(i = begin; i <= end; i++)
			data[i] = temp[i];
	}
	
	private void printAry() {
		for(int i = 0; i < array.length; i++)
			System.out.print(array[i] + " ");
		System.out.println();
	}
}