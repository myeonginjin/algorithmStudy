package a0701.graph;

import java.util.*;
import java.io.*;

public class Main_1260 {
	static int N,m,v;
	static List<Integer>[] arr;
	static boolean[] visit;
	static StringBuilder sb = new StringBuilder();
	
	static void dfs(int n) {
		visit[n] = true;
		sb.append(n+" ");
		
		List<Integer> t = arr[n]; 
		for (int i = 0; i<t.size(); i++) {
			int temp = t.get(i);
			if(!visit[temp]) {
				dfs(temp);
			}
		}
	}
	
	static void bfs(int n) {
		ArrayDeque<Integer> q = new ArrayDeque<>();
		q.addFirst(n);
		visit[n] = true;
		
		while(!q.isEmpty()) {
			int t = q.pollLast();
			sb.append(t+" ");
			List<Integer> tempA = arr[t];
			
			for (int i = 0; i<tempA.size(); i++) {
				int go = tempA.get(i);
				if(visit[go]) continue;
				visit[go] = true;
				q.addFirst(go);
			}
		}
		
		
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str;
		StringTokenizer st;
		
		str = br.readLine();
		st = new StringTokenizer(str);
		N = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		v = Integer.parseInt(st.nextToken());
		
		arr = new List[N+1];
		visit = new boolean[N+1];
		for (int i = 0; i<=N; i++) arr[i] = new ArrayList<>();
		

		for (int i = 0; i<m; i++) {
			str = br.readLine();
			st = new StringTokenizer(str);
			
			int from = Integer.parseInt(st.nextToken());
			int go = Integer.parseInt(st.nextToken());
			
			arr[from].add(go);
			arr[go].add(from);
		}
		
		for (List<Integer> t : arr) Collections.sort(t);
		
		dfs(v);
		sb.append("\n");
		visit = new boolean[N+1];
		bfs(v);
		
		System.out.println(sb);
		//for(List<Integer> a : arr) System.out.println(a.toString());
	}
}
