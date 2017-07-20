package com.inflearn.PriorityQueue;

import com.inflearn.*;
import java.util.Random;

public class PriorityQueue {
	
	public PriorityQueue() {}
	
	public void test(int num) {
		Setting.setCaseNum(num);
		int i = 0;
		while(i < Setting.getCaseNum()) {
			int element = new Random().nextInt(100)+1;
			Setting.createArray();
			Setting.printAry();
			System.out.println("The element is " + element);
			insert(Setting.getArray(), element);
			Setting.printAry();
			System.out.println("The max value is " + extract_max(Setting.getArray()));
			Setting.printAry();
			System.out.println((i+1) + " test has done.");
			System.out.println();
			i++;
		}
	}
	
	private int[] changeArraySize(int[] ary, int num) {
		int[] newArray = new int[ary.length + num];
		for(int i = 0; i < ary.length + num ; i++) {
			if(i == ary.length) break;
			newArray[i] = ary[i];
		}
		return newArray;
	}
	
	private void insert(int[] ary, int element) {
		buildHeap(ary);
		Setting.setArray(changeArraySize(ary, 1));
		
		int[] changed = Setting.getArray();
		changed[changed.length-1] = element;
		
		int i = (changed.length-1) / 2;
		for(; i >= 0; i /= 2) {
			MaxHeapify(changed, i);
			if(i == 0) break;
		}
	}
	
	private void MaxHeapify(int[] ary, int index) {
		int temp, k, i;
		
		if(2*index+1 > ary.length-1) return;
		else if(2*index+1 == ary.length-1) {
			if(ary[2*index+1] > ary[index]) {
				temp = ary[2*index+1];
				ary[2*index+1] = ary[index];
				ary[index] = temp;
			}
			return;
		}
		
		i = index;
		while(2*i+1 <= ary.length-1) {
			if(2*i+2 > ary.length-1) {
				if(ary[2*i+1] > ary[i]) {
					temp = ary[2*i+1];
					ary[2*i+1] = ary[i];
					ary[i] = temp;
				}
				break;
			}
			if(ary[2*i+1] > ary[2*i+2]) k = 2*i+1;
			else k = 2*i+2;
			if(ary[k] > ary[i]) {
				temp = ary[k];
				ary[k] = ary[i];
				ary[i] = temp;
			}
			i = k;
		}
	}
	
	private void buildHeap(int[] ary) {
		for(int i = (ary.length-1)/2; i >= 0; i--)
			MaxHeapify(ary, i);
	}
	
	private int extract_max(int[] ary) {
		int result = ary[0];
		ary[0] = ary[ary.length-1];
		Setting.setArray(changeArraySize(ary, -1));
		MaxHeapify(Setting.getArray(),0);
		return result;
	}
}
