import java.util.Scanner;

public class RecursiveStringMethods {
	public static void main(String args []){
		System.out.print("Insert a word>>");
		Scanner scan = new Scanner(System.in);
		String word = scan.next();
		int result = Length(word);
		System.out.println(word + "의 길이는 : " + result);
		Print(word);
		System.out.println();
		reversePrint(word);
		System.out.println();
		printCharReverse(word);
	}
	
	static int Length(String str){
		if(str.equals("")) return 0;
		return 1 + Length(str.substring(1));
	}
	
	static void Print(String str){
		if(str.equals("")){
			return;
		}
		System.out.print(str.charAt(0));
		Print(str.substring(1));
	}
	
	//내가 작성
	static void reversePrint(String str){
		if(Length(str) == 0 ) return;
		System.out.print(str.charAt(Length(str)-1));
		reversePrint(str.substring(0,Length(str)-1));
	}
	
	//강의 작성
	static void printCharReverse(String str){
		if(str.length() == 0) return;
		printCharReverse(str.substring(1));
		System.out.print(str.charAt(0));
	}
}