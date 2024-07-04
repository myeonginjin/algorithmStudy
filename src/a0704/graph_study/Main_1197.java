package a0704.graph_study;

import java.util.*;
import java.io.*;

public class Main_1197 {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str;
		StringTokenizer st;
		
		str = br.readLine();
		st = new StringTokenizer(str);
		
		int v = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		
		List<int[]>[] g = new List[v]; for (int i = 0; i<v; i++) g[i] = new ArrayList<>();
		
		for (int i = 0; i<e; i++) {
			str = br.readLine();
			st = new StringTokenizer(str);
			int from = Integer.parseInt(st.nextToken())-1;
			int to = Integer.parseInt(st.nextToken())-1;
			int w = Integer.parseInt(st.nextToken());
			
			g[from].add(new int[] {to,w});
			g[to].add(new int[] {from,w});
		}
		
		boolean[] visit = new boolean[v];
		int[] w = new int[v]; for (int i = 0; i<v; i++) w[i] = Integer.MAX_VALUE;
		
		w[0] = 0;
		int sum = 0; int cnt = 0;
		
		for (int i = 0; i<v; i++) {
			int minVertex = -1;
			int min = Integer.MAX_VALUE;
			
			for (int j = 0; j<v; j++) {
				if(!visit[j] && min > w[j]) {
					min = w[j];
					minVertex = j;
				}
			}
			
			visit[minVertex] = true;
			sum += w[minVertex];
			if(cnt++ == v-1) break;
			
			for (int[] j : g[minVertex]) {
				if(!visit[j[0]] && w[j[0]] > j[1]) {
					w[j[0]] = j[1];
				}
			}
		}
		System.out.println(sum);
	}

}
