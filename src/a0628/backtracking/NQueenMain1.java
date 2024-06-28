package a0628.backtracking;

import java.util.*;

public class NQueenMain1 {
	static int N, ans, col[];
	
	static boolean isAvailable(int rowIndex) {
		for (int j = 0; j<rowIndex; j++) {
			
			//대각선의 있는 두 좌표는 X의 증가폭/감소폭과 y의 증가폭/감사폭이 일정함. 그렇기에 두 좌표의 x와 y값 차이는 동일함
			if(col[rowIndex]==col[j] || Math.abs(col[rowIndex]-col[j]) == rowIndex-j) return false;			
		}
		return true;
	}
	
	static void nqueen(int rowIndex) {
		if(rowIndex==N) {
			ans++;
			return;
		}
			
		
		for (int i = 0; i<N; i++) {
			col[rowIndex] = i;
			if(isAvailable(rowIndex)) nqueen(rowIndex+1);
			
		}
		
	}
	

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		N = 8;
		col = new int[N];
		ans = 0;
		nqueen(0);
		System.out.println(ans);
		sc.close();
	}
}