package com.inflearn;

import java.util.Random;

public class Setting {
	private static int caseNum;
	private static int[] array;
	
	public static int[] getArray() {
		return array;
	}
	
	public static void setArray(int[] ary) {
		array = ary;
	}
	
	public static void createArray() {
		
		Random rand = new Random();
		
		int size = rand.nextInt(10)+2;
		array = new int[size];
		for(int i = 0; i < size; i++)
		{
			array[i] = rand.nextInt(100);
		}
	}
	
	public static int getCaseNum() {
		return caseNum;
	}

	public static void setCaseNum(int caseNum) {
		Setting.caseNum = caseNum;
	}
	
	public static void printAry() {
		for(int i = 0; i < array.length; i++)
			System.out.print(array[i] + " ");
		System.out.println();
	}
}
