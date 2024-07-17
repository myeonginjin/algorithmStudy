package study;


import java.util.*;

public class Main_10814 {
	
	static class People {
		int a;
		String n;
		int d;
		
		public People(int age, String name, int d) {
			this.a = age;
			this.n = name;
			this.d = d;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		People[] arr = new People[n];
		
		for (int i = 0; i<n; i++) {
			int a = sc.nextInt();
			String na = sc.next();
			
			arr[i] = new People(a, na, i);
		}
		
		Arrays.sort(arr, (o1,o2) -> {
			if(o1.a == o2.a) {
				return o1.d - o2.d;
			}
			return 	Integer.compare(o1.a, o2.a);
		});
		
		for (int i = 0; i<n; i++) {
			System.out.println(arr[i].a +" "+ arr[i].n);
		}
		
	}
}
