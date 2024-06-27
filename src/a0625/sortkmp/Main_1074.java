package a0625.sortkmp;


import java.util.*;
import java.io.*;

public class Main_1074 {
	static int n,ansR,ansC;
	static int[][] arr;
	static int cnt = 0;
	static boolean find = false;
	
	static void div(int r, int rL , int c, int cL) {
		if(find) return;
		
		//z모양으로 탐색할 수 있는 최대 분할 상태, 2*2크기의 배열에 접근
		if(rL-r == 2) {
			//해당 배열에 찾고자 하는 원소가 있는지 확인
			if(ansR>=r && ansR < rL && ansC >= c && ansC <cL) {
				for (int i = r; i<rL; i++) {
					for (int j = c; j<cL; j++) {
						//찾았음
						if(i==ansR && j == ansC) {
							
							//디버깅용
							//System.out.println(r +" " + rL + " " + c +" "+cL);
							find = true;
							return;
						}
						cnt++;
					}
				}
			}
			//찾고자 하는 원소가 있는 배열이 아니라면 굳이 탐색해볼 필요없음. 4회 방문처리
			cnt += 4;
			
			//디버깅용
			//System.out.printf(" 시작점 : (%d, %d) 끝점 : (%d, %d)   cnt : %d",r,c,rL,cL,cnt);
			
			//다음 구역으로 넘어감
			return;
		}
		
		
		int rM = (r+rL)/2;
		int cM = (c+cL)/2;
		
		//왼쪽 위 구역 탐색 시작
		div(r, rM, c, cM);
		//오른쪽 위 구역 탐색 시작
		div(r,rM, cM, cL);
		//왼쪽 아래 
		div(rM, rL, c, cM);
		//오른쪽 아래
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