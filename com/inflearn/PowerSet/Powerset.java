package com.inflearn.PowerSet;

import java.util.Scanner;

class Powerset {
	private int range = 96;
	private char[] set;
	private boolean[] include;
	
	public void test() {
		setRange();
		createSet();
		//printSet();
		printPowerSet(0);
	}
	
	private void setRange() {
		Scanner scan = new Scanner(System.in);
		int num;
		
		while(true) {
			System.out.print("Insert the range of a set(1~26)");
			num = scan.nextInt();
			if(1 <= num && num <= 26) {
				range += num;
				break;
			} 
		}
	}
	
	private void createSet() {
		set = new char[range-96];
		include = new boolean[range-96];
		
		int j = 0;
		for(int i = 96; i < range; i++)
		{
			set[j] = (char)(i+1);
			j++;
		}
	}
	
	private void printSet() {
		for(int i = 0; i < set.length; i++)
			System.out.print(set[i] + " ");
	}
	
	private void printPowerSet(int k) {
		if(k == set.length) {
			for(int i = 0; i < set.length; i++)
				if(include[i]) System.out.print(set[i] + " ");
			System.out.println();
		}
		else {
			include[k] = true;
			printPowerSet(k+1);
			include[k] = false;
			printPowerSet(k+1);
		}
	}
}
