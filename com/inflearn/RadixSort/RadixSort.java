package com.inflearn.RadixSort;

import java.util.Random;

public class RadixSort {
	private int caseNum;
	private final int radix = 3;
	private int[] array;
	
	public RadixSort() {}	
	
	public void test(int num) {
		setCaseNum(num);
		int i = 0;
		while(i < getCaseNum()) {
			createArray();
			printArray();
			radixSort(getArray(), getRadix());
			printArray();
			System.out.println();
			System.out.println((i+1) + " test has done.");
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
	
	private int[] getArray() {
		return array;
	}
	
	private void createArray() {
		array = new int[new Random().nextInt(10)+1];
		int i, number, hundred, ten, unit;
		
		i = 0;
		while(i <= array.length-1) {
			hundred = new Random().nextInt(9)+1;
			ten = new Random().nextInt(10);
			unit = new Random().nextInt(10);
			number = hundred*100 + ten*10 + unit;
			array[i++] = number;
		}
	}
	
	private void printArray() {
		for(int i = 0; i < array.length; i++)
			System.out.print(array[i] + " ");
		System.out.println();
	}
	
	private int powerFunction10(int radix) {
		if(radix == 0) return 1;
		return 10*powerFunction10(--radix);
	}
	
	private int getRadix() {
		return radix;
	}
	
	private int extractRadixNum(int number, int radix, int maxRadix) {
		int quotient = 0;
		int i = 0;
		while((maxRadix-1) - i>= radix) {
			quotient = number / powerFunction10((maxRadix-1) - i);
			number = number % powerFunction10((maxRadix-1) - i);
			i++;
		}
		return quotient;
	}
	
	private void radixArrange(int[] ary, int radix, int maxRadix) {
		int[] temp;
		int[] countAry;
		int[] accumulateAry;
		int max = extractRadixNum(ary[0], radix, maxRadix);
		int i;
		
		for(i = 1; i < ary.length; i++)
			max = Math.max(max, extractRadixNum(ary[i], radix, maxRadix));
		
		countAry = new int[max+1];
		accumulateAry = new int[countAry.length];
		
		for(i = 0; i < countAry.length; i++)
			countAry[i] = 0;
		
		for(i = 0; i < ary.length; i++)
			countAry[extractRadixNum(ary[i], radix, maxRadix)]++;
		
		for(i = 0; i < countAry.length; i++)
		{
			if(i == 0) accumulateAry[0] = countAry[0];
			else accumulateAry[i] = accumulateAry[i-1] + countAry[i];
		}
		
		temp = new int[ary.length];
		for(i = ary.length-1; i >= 0; i--) {
			temp[accumulateAry[extractRadixNum(ary[i], radix, maxRadix)]-1] = ary[i];
			accumulateAry[extractRadixNum(ary[i], radix, maxRadix)]--;
		}
		
		for(i = 0; i < temp.length; i++)
			ary[i] = temp[i];
	}
	
	private void printCheck(int[] ary) {
		System.out.println();
		for(int i = 0; i < ary.length; i++)
			System.out.print(ary[i] + " ");
		System.out.println();
		System.out.println();
	}
	
	private void radixSort(int[] ary, int maxRadix){
		for(int i = 0; i < maxRadix; i++) {
			radixArrange(ary, i, maxRadix);
		}
	}
}
