package a0704.graph_study;

import java.util.*;
import java.io.*;

public class Main_4485_pq {
	static int n;
	static List<int[]>[] g;
	static boolean[] v;
	static int[] d;
	static StringBuilder sb = new StringBuilder();
	
	static void dijkstra(int strLoopi, int caseNum) {

		d[0] = 0;
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2) -> {return Integer.compare(o1[1], o2[1]);});
		pq.offer(new int[] {0,d[0]});
		
		while(!pq.isEmpty()) {
			int[] t = pq.poll();
			int min = t[1];
			int minVertex = t[0];
			if(v[minVertex]) continue;
			
			v[minVertex] = true;
			
			for (int[] j : g[minVertex]) {
				if(!v[j[0]] && d[j[0]] > j[1] + min) {
					d[j[0]] = j[1] + min;
					pq.offer(new int[] {j[0] , d[j[0]]});
				}
			}
		}
		
//		for (int i = 0; i<n*n; i++) {
//			int min = Integer.MAX_VALUE;
//			int minVertex = -1;
//			
//			for (int j = 0; j<(int)Math.pow(n,2); j++) {
//				if(!v[j] && min > d[j]) {
//					min = d[j];
//					minVertex = j;
//				}
//			}
//			
//			v[minVertex] = true;
//			
//			for (int[] j : g[minVertex]) {
//				if(!v[j[0]] && d[j[0]] > j[1]+min) {
//					d[j[0]] = j[1] + min;
//				}
//			}
//		}
		sb.append("Problem "+caseNum+": "+(d[n*n-1]+strLoopi));
		sb.append("\n");
	}
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/a0704/graph_study/input_4485"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str;
		StringTokenizer st;
		int caseNum = 0;
		
		while(true) {
			n = Integer.parseInt(br.readLine());
			if (n==0) break;
			
			g = new ArrayList[(int)Math.pow(n,2)]; for(int i = 0; i<(int)Math.pow(n,2); i++) g[i] = new ArrayList<>();
			v = new boolean[(int)Math.pow(n,2)];
			d = new int[(int)Math.pow(n,2)];  for(int i = 0; i<(int)Math.pow(n,2); i++) d[i] = Integer.MAX_VALUE;
			
			int[][] arr = new int[n][n];
			for (int i = 0; i<n; i++) {
				str = br.readLine();
				st = new StringTokenizer(str);
				for (int j = 0; j<n; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int vertexIndex = 0;
			for (int i =0 ; i<n; i++) {
				for (int j = 0; j<n; j++) {
					if(j!=n-1) {
						g[vertexIndex].add(new int[] {vertexIndex+1, arr[i][j+1]});
						if(j!=0) g[vertexIndex].add(new int[] {vertexIndex-1, arr[i][j-1]});
					}
					if(i!=n-1) {
						g[vertexIndex].add(new int[] {vertexIndex+n, arr[i+1][j]});
						if(i!=0) g[vertexIndex].add(new int[] {vertexIndex-n, arr[i-1][j]});
					}
					vertexIndex++;
				}
			}
			dijkstra(arr[0][0],++caseNum);
		}
		
		br.close();
		System.out.println(sb);
	}
}
