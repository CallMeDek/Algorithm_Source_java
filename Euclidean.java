import java.util.Scanner;

public class Euclidean {
	public static void main(String args []){
		int num1, num2, result;
		
		System.out.print("Insert two numbers>>");
		Scanner scan = new Scanner(System.in);
		num1 = scan.nextInt();
		num2 = scan.nextInt();
		
		result = asInteration_gcd(num1, num2);
		System.out.println("Result(Interation_gcd) : " + result);
		result = asRecursion_gcd(num1, num2);
		System.out.println("Result(Recursion_gcd) : " + result);
	}
	
	static int asInteration_gcd(int a, int b){
	
		int result;
		int dividend = a;
		int divisor = b;
		int remainder = a % b;
		
		while(remainder > 0 )
		{
			dividend = divisor;
			divisor = remainder;
			remainder = dividend % divisor;
		}
		
		return divisor;
	}
	
	static int asRecursion_gcd(int a, int b){
		if(b == 0) return a;
		return asRecursion_gcd(b, a % b);
	}
}