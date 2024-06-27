package a0625.sortkmp;
import java.io.*;
import java.time.ZonedDateTime;
import java.util.*;

public class Main_2630 {
	static int n;
	static int[][] arr;
	static int oneCnt = 0;
	static int zeroCnt = 0;
	
	static boolean check(int r, int r2, int c, int c2) {
		int type = arr[r][c];
		
		//System.out.println(r+" "+ r2+" "+c+" "+c2);
		
		//if( r == 0  && r2 == 4 && c == 0 && c2==0) {
			//System.out.println(type);
		//}
		
		for (int i = r; i<r2; i++) {
			for (int j = c; j<c2; j++) {
				if(arr[i][j] != type) {
					return false;
				}
			}
		} 
		
		if(type ==1) oneCnt++;
		else zeroCnt++;
		
		return true;
	}
	
	static void div(int r, int r2, int c, int c2) {
		if(check(r,r2,c,c2)) return;
		
        int rM = (r+r2)/2;
        int cM = (c+c2)/2;
        
		//왼쪽 위
		div(r, rM, c, cM);
		//오른쪽 위 
		div(r, rM, cM, c2);
		//왼쪽 아래
		div(rM, r2, c, cM);
		//왼쪽 아래
		div(rM, r2, cM, c2);
		
		return;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str;
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		
		for (int i = 0; i<n; i++) {
			str = br.readLine();
			st = new StringTokenizer(str);
			
			for (int j = 0; j<n; j++) {
				arr[i][j]  = Integer.parseInt(st.nextToken());
			}
		}
		
		div(0,n,0,n);
        
        System.out.println(zeroCnt+"\n"+oneCnt);
	}
}