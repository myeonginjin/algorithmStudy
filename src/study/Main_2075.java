package study;

import java.util.*;

public class Main_2075 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] arr = new int[n][n];
		
		for (int i = 0; i<n; i++) {
			for (int j = 0; j<n; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		
		int pr = n-1;
		int pc = 0;
		int closerAns = 0;
		
		while (pr < n && pc < n && pr>=0 && pc>=0) {
			int curN = arr[pr][pc];
			int morebig = 0;
			
			if(closerAns > arr[pr][pc]) {
				pc++;
				pr = n-1;
				continue;
			}
			sercch : for (int c = 0; c<n; c++) {
				
				for (int r = 0; r<n; r++) {
					if(pc==c && pr == r) continue;
					int secN = arr[r][c];
					
					if(secN > curN) morebig++;
					
					if(morebig==n) {
						morebig = Math.max(morebig, arr[pr][pc]);
						//System.out.println(curN +" "+morebig);
						pr = n-1;
						pc++;
						break sercch;
					}
				}
			}
			
			if (morebig==n) {
				
			} else {
				//System.out.println("wow"+arr[pr][pc]);
				if (morebig == n-1) {
					System.out.println(arr[pr][pc]);
					break;
				} else {
					if (pr == 0) {
						pr = n-1;
						pc++;
					} else {
						pr--;
					}
					
				}
			}
			
		}
					
			
		
		
	}

}
