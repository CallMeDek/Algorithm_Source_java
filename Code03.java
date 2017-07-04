public class Code03{

	public static void main(String args[]){
		long result = func(1000);
		System.out.println(result);
	}

	static long func(int n){
		if(n <= 0)
			return 0;
		return n + func(n-1);
	}
}