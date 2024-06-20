package a0619.recu;

public class RecursiveTest {
	
	static int fac(int n) {
		if(n==1 || n == 0) {
			return 1;
		}
		
		
		return n * fac(n-1);
	
	}
	
	static int fibo(int n) {
		if(n <=1) {
			return n;
		}
		
//		if(n == 1) {
//			return 1;
//		}
//		if (n == 0) {
//			return 0;
//		}
		
		return fibo(n-1) + fibo(n-2);
	}
	
	static void recur(int n) {
//		if(n>0) {
//			recur(n-1);
//			System.out.println(n);
//			recur(n-2);
//		}
		
		//위를 반대로 표현하면
		
		if (n <= 0) return;
		recur(n-1);
		System.out.println(n);
		recur(n-2);
	}

	public static void main(String[] args) {
		//System.out.println(fac(5));
		//System.out.println(fibo(5));
		recur(4);

	}

}
