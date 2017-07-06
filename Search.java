import java.util.Scanner;

public class Search{
	public static void main(String args []){
		System.out.print("Insert five numbers>>");
		Scanner scan = new Scanner(System.in);
		int[] test = new int[5];
		for(int i = 0; i < test.length; i++)
			test[i] = scan.nextInt();
			
		System.out.print("Insert the what you want to find>>");
		int number = scan.nextInt();
		
		int result = searchAsIteration(test, number);
		System.out.println("(Iteration)The result is " + result);
		
		result = searchAsRecursion(test, 0, test.length-1, number);
		System.out.println("(Recursion)The result is " + result);
		
		result = searchAsRecursionAnother(test, 0, test.length-1, number);
		System.out.println("(Another recursion)The result is " + result);
		
		//result = binarySearchAsRecursion(test, 0, test.length-1, number);
		//System.out.println("(binary search - recursion)The result is " + result);
		
		result = findMaxRecursion(test, 0, test.length-1);
		System.out.println("(Finding max num)The result is " + result);
	}
	
	static int searchAsIteration(int[] arr, int num){
		for(int i = 0; i < arr.length; i++)
		{
			if(arr[i] == num)
				return i;
		}
		return -1;
	}
	
	static int searchAsRecursion(int[] arr, int begin, int end, int num){
		if(begin > end) return -1;
		else if (arr[end] == num) return end;
		return searchAsRecursion(arr, begin, end-1, num);
	}
	
	static int searchAsRecursionAnother(int[] arr, int begin, int end, int num){
		if(begin > end) return -1;
		else{
			int middle = (begin + end) / 2;
			if(arr[middle] == num) return middle;
			int result = searchAsRecursionAnother(arr, begin, middle-1, num);
			if(result != -1) return result;
			result = searchAsRecursionAnother(arr, middle+1, end, num);
			return result;
		}
	}
	
	static int findMaxRecursion(int[] arr, int begin, int end){
		if(begin == end) return arr[end];
		return Math.max(arr[end], findMaxRecursion(arr, begin, end-1));
	}
	
	static int binarySearchAsRecursion(int[] arr, int begin, int end, int num){
		int result = 0;
		int middle = (begin + end) / 2;
		
		if(begin > end) return -1;
		
		if(arr[middle] == num) return middle;
		
		else if(arr[middle] > num)
			result = searchAsRecursionAnother(arr, begin, middle-1, num);
		else
			result = searchAsRecursionAnother(arr, middle+1, end, num);
			
		return result;
	}
	
	//compareTo();를 이용해서 구현 할수도 있다.
}