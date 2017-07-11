package com.inflearn.Blob;

import java.util.Random;
import java.util.Scanner;

public class CountingCellsInABlob {

	private static int[][] patternFile;
	private static int length;
	private static int testCount;
	
	public static void test(int num) {
		setLength();
		createFile();
		printFile(patternFile);
		//Setting is done.
		setTestCount(num);
		printResult();
	}
	
	static void setTestCount(int num) {
		testCount = num;
	}
	
	static void setLength() {
		Scanner scan = new Scanner(System.in);
		System.out.print("Insert length number>>");
		length = scan.nextInt();
	}
	
	static void printFile(int[][] file) {
		for(int i = 0; i < file.length; i++) {
			for(int j = 0; j < file.length; j++) {
				System.out.print(file[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	static void createFile(){
		int number;
		patternFile = new int[length][length];
		
		for(int i = 0; i < length; i++) {
			for(int j = 0; j < length; j++) {
				number = new Random().nextInt(2);
				patternFile[i][j] = number;
			}
		}
		
	
	}
	
	/* 0 is a background pixel
	   1 is an image pixel
	   2 is an image pixel which is already counted */
	static int counting(int x, int y) {
		if(x < 0 || y < 0 || x >= patternFile.length || y >= patternFile.length) return 0;
		if(patternFile[x][y] != 1) return 0;
		else {
			patternFile[x][y] = 2;
			return 1 + counting(x, y-1) + counting(x+1, y-1) + counting(x+1, y) + counting(x+1, y+1)
			+ counting(x, y+1) + counting(x-1, y+1) + counting(x-1, y) + counting(x-1, y-1);
		}
	}
	
	static void printResult() {
		int x;
		int y;
		int i = 0;
		int result;
		Random position = new Random();
		
		while(i < testCount) {
			x = position.nextInt(length);
			y = position.nextInt(length);
			result = counting(x, y);
			System.out.println("("+x+", "+y+") Result is " + result);
			i++;
		}
	}	
}
