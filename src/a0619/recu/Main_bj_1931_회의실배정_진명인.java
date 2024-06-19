package a0619.recu;

import java.util.*;
import java.lang.*;
import java.io.*;

public class Main_bj_1931_회의실배정_진명인 {
	public static int n;
	public static int maxEndT = 0;
	
	public static boolean canMeeting(int s, int e, boolean[] visited) {
		for (int i = s; i<e; i++) {
			if (visited[i]) return false;
		}
		return true;
	}
	
	public static void visitMeeting(int s, int e, boolean[] visited) {
		for (int i = s; i<e; i++) {
			visited[i] = true;
		}
	}
	
	public static void resetSchedule(int s, int e, boolean[] visited) {
		for (int i = 0; i<=maxEndT; i++) {
			if(i >= s && i<e) continue;
			visited[i] = false;
		}
	}

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_bj_1931"));
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		String str;
		n = Integer.parseInt(br.readLine());
		
		int[][] times = new int[n][2];
		int startT, endT;
		
		
		for (int i = 0; i<n; i++) {
			str = br.readLine();
			st = new StringTokenizer(str," ");
			startT = Integer.parseInt(st.nextToken());
			endT = Integer.parseInt(st.nextToken());
			
			times[i][0] = startT;
			times[i][1] = endT;
			
			maxEndT = Math.max(maxEndT, endT);
		}
		//for(int[] t : times) System.out.println(Arrays.toString(t));
		
		
		int maxCnt = 0; 
		
		//첫번째 회의 선택
		for (int i = 0; i<n; i++) {
			int cnt = 1; 
			boolean[] visited = new boolean[10000000]; 
			visitMeeting(times[i][0], times[i][1], visited);
			
			//두번째 회의 선택 
			for (int j = i+1; j<n; j++) {
				if(canMeeting(times[j][0], times[j][1], visited)) {
					visitMeeting(times[j][0], times[j][1], visited);
					cnt = 2;
					
					//나머지 가능한 회의들 선택
					for (int k = j+1; k<n; k++) {
						if(canMeeting(times[k][0], times[k][1], visited)) {
							visitMeeting(times[k][0], times[k][1], visited);
							cnt++;
						}
					}
					
					maxCnt = Math.max(maxCnt, cnt);
					
					
//					if(maxCnt==5) {
//						System.out.println("i : "+i+" j: "+j);
//						System.out.println(Arrays.toString(visited));
//						System.out.println();
//						System.out.println();
//						System.out.println();
//						
//					}
					
					
					resetSchedule(times[i][0], times[i][1], visited);
				}
			}
		}
		System.out.println(maxCnt);
		

	}

}
