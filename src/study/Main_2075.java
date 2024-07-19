package study;

import java.awt.image.SampleModel;
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
		int r = 0;
		for (int c = 0; c<n; c++) {
			int dif = arr[r][c];
			int smallCnt = 0;
			
			serch : for (int j = 0; j<n; j++) {
				if(j==c) continue;
				for (int i = 0; i<n; i++) {
					if (dif  > arr[i][j]) smallCnt++;
					
					//해당 dif는 탈락
					if(smallCnt==n) {
						//해당 줄은 끝낫음 이미
						if(r+1==n) {
							break serch;
						}
						//해당 줄의 다음으로 큰 수로 다시 시작
						dif = arr[++r][c];
						smallCnt--;
						i--;
					}
				}
			}
			
			System.out.println(dif+"   "+smallCnt);
		}
		
	}

}
