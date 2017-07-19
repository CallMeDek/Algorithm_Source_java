package com.inflearn.HeapSort;

import com.inflearn.Setting;

public class HeapSort {
	
	public HeapSort(){
		
	}
	
	public void test(int num) {
		int i = 0;
		Setting.setCaseNum(num);
		while(i < Setting.getCaseNum()) {
			Setting.createArray();
			Setting.printAry();
			heapSort(Setting.getArray());
			Setting.printAry();
			System.out.println((i+1) + " test is done.");
			System.out.println();
			i++;
		}
	}
	
	private void MaxHeapifyRecursion(int[] ary, int index, int end) {
		int temp, k;
		if(2*index+1 > end) return;
		else if(2*index+1 == end) {
			if(ary[2*index+1] > ary[index]) {
				temp = ary[2*index+1];
				ary[2*index+1] = ary[index];
				ary[index] = temp;
			}
			return;
		}
		else {
			if(ary[2*index+1] > ary[2*index+2]) k = 2*index+1;
			else k = 2*index+2;
			if(ary[k] > ary[index]) {
				temp = ary[index];
				ary[index] = ary[k];
				ary[k] = temp;
			}
			MaxHeapifyRecursion(ary, k, end);
		}
	}
	
	private void MaxHeapifyIteration(int[] ary, int index, int end) {
		int i, temp, k;
		
		if(2*index+1 == end) {
			if(ary[2*index+1] > ary[index]) {
				temp = ary[2*index+1];
				ary[2*index+1] = ary[index];
				ary[index] = temp;
			}
			return;
		}
		
		i = index;
		while(2*i+1 < end) {
			if(ary[2*i+1] > ary[2*i+2]) k = 2*i+1;
			else k = 2*i+2;
			if(ary[k] > ary[i]) {
				temp = ary[i];
				ary[i] = ary[k];
				ary[k] = temp;
			}
			i = k;
		}
	}
	
	private void buildHeap(int[] ary, int end){
		for(int i = (end)/2; i >= 0; i--)
			MaxHeapifyRecursion(ary, i, end);
			//MaxHeapifyIteration(ary, i);
	}
	
	private void heapSort(int[] ary) {
		int temp, end;
		end = ary.length-1;
		do {
			buildHeap(ary, end);
			temp = ary[end];
			ary[end--] = ary[0];
			ary[0] = temp;
		}while(end >= 0);
	}
}
