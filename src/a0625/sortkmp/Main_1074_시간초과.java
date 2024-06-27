package a0625.sortkmp;


import java.util.*;
import java.io.*;

public class Main_1074_시간초과 {
	static int n,ansR,ansC;
	static int[][] arr;
	static int cnt = 0;
	static boolean find = false;
	
	static void div(int r, int rL , int c, int cL) {
		if(find) return;
		
		
		if(rL-r == 2) {

			
			if(ansR>=r && ansR <= rL && ansC >= c && ansC <=cL) {
				for (int i = r; i<rL; i++) {
					for (int j = c; j<cL; j++) {
						
						if(i==ansR && j == ansC) {
							
							System.out.println(r +" " + rL + " " + c +" "+cL);
							System.out.println(cnt + " !!!");
							find = true;
							return;
						}
						cnt++;
					}
				}
			}
			else cnt += 4;
			
			
			System.out.printf(" 시작점 : (%d, %d) 끝점 : (%d, %d)   cnt : %d",r,c,rL,cL,cnt);
			System.out.println();
			System.out.println();
			System.out.println();
			
			return;
		}
		
		int rM = (r+rL)/2;
		int cM = (c+cL)/2;
		
		div(r, rM, c, cM);
		div(r,rM, cM, cL);
		div(rM, rL, c, cM);
		div(rM,rL, cM, cL);
	}

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_1074"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str);
		n = Integer.parseInt(st.nextToken());
		ansR = Integer.parseInt(st.nextToken());
		ansC = Integer.parseInt(st.nextToken());
		
		arr = new int[(int) Math.pow(n,2)][(int)Math.pow(n,2)];
		
		div( 0 ,(int)Math.pow(2, n), 0, (int)Math.pow(2, n));
		
		System.out.println(cnt);
	} 
}
