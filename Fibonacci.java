import java.util.Scanner;

public class Fibonacci {
	public static void main(String args []){
		System.out.print("Insert count>>");
		Scanner scan = new Scanner(System.in);
		int count_number = scan.nextInt();
		int result = 0;
		result = asIteration(count_number);
		System.out.println("The result of Iteration = " + result);
		result = asRecursion(0, 1, count_number);
		System.out.println("The result of Recursion = " + result);
	}
	
	static int asIteration(int num){
		int first = 0;
		int second = 1;
		int sum = 0;
		int i = 0;
		
		while(i < num){
			sum = first + second;
			first = second;
			second = sum;
			i++;
		}
		return sum;
	}
	
	static int asRecursion(int front, int back, int num){
		if(num == 1) return front+back;
		return asRecursion(back, front + back, --num);
	}
}