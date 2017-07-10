package com.inflearn;

import java.util.Random;
import java.util.Scanner;

public class Maze {
	
	private static final int EXPLORED = 2;
	private static final int PATH = 3;
	private static int[][] aMaze;
	private static int length;
	
	public static void getLength() {
		Scanner scan = new Scanner(System.in);
		System.out.print("Insert length>>");
		length = scan.nextInt();
	}

	public static void test() {
		// TODO Auto-generated method stub
				
				aMaze = createMaze(length);
				printMaze(aMaze);
				
				// -- Setting is done --
				
				boolean result = findPath(0, 0, length);
				if(result)
					printMaze(aMaze);
				else
					System.out.println("There is no way");
	}
	
	public static int[][] createMaze(int len) {
		
		int[][] maze;
		int number;
		int maximum_wall = 10;
		
		maze = new int[len][len];
		maze[0][0] = 1;
		maze[len-1][len-1] = 1;
		for(int i = 0; i < len; i++) {
			for(int j = 0; j < len; j++) {
				if(i == 0 && j == 0) continue;
				if(i == len-1 && j == len-1) continue;
				number = new Random().nextInt(2);
				if(number == 0) { 
					if(maximum_wall > 0) { 
						maze[i][j] = number;
						maximum_wall--;
						continue;
					}
					maze[i][j] = 1;
					continue;
				}
				maze[i][j] = number;
			}
		}
		return maze;
	}
	
	public static void printMaze(int[][] maze) {
		for(int i = 0; i < maze.length; i++) {
			for(int j = 0; j < maze.length; j++)
				System.out.print(maze[i][j] + " ");
			System.out.println();
		}
		System.out.println();
	}
	
	public static boolean findPath(int x, int y, int len) {
		if(x < 0 || y < 0 || x >= len || y >= len) return false;
		if(x==len-1&&y==len-1) {
			aMaze[x][y] = PATH;
			return true;
		}
		if(aMaze[x][y] != 1) return false;
		else {
			aMaze[x][y] = PATH;
			if(findPath(x,y-1, len)||findPath(x+1,y, len)
			||findPath(x,y+1, len)||findPath(x-1,y, len)) 
				return true;
			aMaze[x][y] = EXPLORED;
			return false;
		}
	}
}
