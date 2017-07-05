import java.util.Scanner;

public class RecursiveDataMethods {
	public static void main(String args []){
		System.out.print("Insert a number>>");
		Scanner scan = new Scanner(System.in);
		int number = scan.nextInt();
		toBinary(number);
		System.out.println();
		int[] arr = {1, 2, 3, 4, 5};
		int sum = sumOfArray(arr.length, arr);
		System.out.println("arr = {1, 2, 3, 4, 5}ÀÇ ÇÕÀº : " + sum); 
		printOfArray(arr.length, arr);
		System.out.println();
		int[] test = new int[5];
		allocateElement(test.length, test, scan);
		printOfArray(test.length, test);
		System.out.println();
	}
	
	static void toBinary(int num){
		if((num / 2) == 0){
			System.out.print(1);
			return;
		}
		toBinary(num / 2);
		System.out.print(num % 2);
		return;
	}
	
	static int sumOfArray(int len, int[] arr){
		if(len == 0) return 0;
		return arr[len-1] + sumOfArray(len-1, arr);
	}
	
	static void printOfArray(int len, int[] arr){
		if(len == 0) return;
		printOfArray(len-1, arr);
		System.out.print(arr[len-1]);
	}
	
	static void allocateElement(int len, int[] arr, Scanner in){
		if(len == 0) return;
		allocateElement(len-1, arr, in);
		System.out.print("Insert " + len + " number>>");
		arr[len-1] = in.nextInt();
	}
}