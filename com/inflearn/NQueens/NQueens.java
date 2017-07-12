package com.inflearn.NQueens;

import java.util.Scanner;

public class NQueens {
	private int testCase;
	private int length;
	private int[] cols;
	
	public NQueens(int num) {
		testCase = num;
	}
	
	public void test() {
		int i = 0;
		
		while(i < testCase) {
			setLength();
			setCols();
			nQueens(0);
			i++;
		}
		System.out.println();
		System.out.println("Test is done.");
	}
	
	private void setLength() {
		Scanner scan = new Scanner(System.in);
		System.out.print("Insert length of a chessboard>>");
		length = scan.nextInt();
	}
	
	private void setCols() {
		cols = new int[length];
	}
	
	private boolean nQueens(int level) {
		if(!promised(level)) return false;
		else if(level == length-1) {
			for(int i = 0; i < cols.length; i++)
				System.out.print(cols[i] + " ");
			return true;
		}
		else {
			for(int i = 0; i < length; i++)
			{
				cols[level+1] = i;
				if(nQueens(level+1)) return true;
			}
			return false;
		}
	}
	
	private boolean promised(int level) {
		for(int i = 0; i < level; i++)
		{
			if(cols[i] == cols[level]) return false;
			else if((level-i) == Math.abs(cols[level] - cols[i])) return false;
		}
		return true;
	}
}
