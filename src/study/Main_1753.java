package study;

import java.util.*;
import java.io.*;
import java.lang.reflect.WildcardType;

public class Main_1753 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/study/input_1753"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str;
		StringTokenizer st;
		
		str = br.readLine();
		st = new StringTokenizer(str);
		
		int n = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		
		int strV = Integer.parseInt(br.readLine());
		
		List<int[]>[] g = new List[n+1]; for (int i = 0; i<=n; i++) g[i] = new ArrayList<>();
		
		for (int i = 0; i<e; i++) {
			str = br.readLine();
			st = new StringTokenizer(str);
	
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int dis = Integer.parseInt(st.nextToken());
			g[from].add(new int[] {to,dis});
			
		}

//		for (int j = 1; j<=n; j++) {
//			for (int i = 0; i<v[j].size(); i++) {
//				System.out.print(Arrays.toString(v[j].get(i)));
//			}
//			System.out.println();
//		}
		
		boolean[] v = new boolean[n+1];
		int[] w = new int[n+1]; for (int i = 0; i<=n; i++) w[i] = Integer.MAX_VALUE;
		
		PriorityQueue<int[]> pq = new PriorityQueue<>( (o1,o2) -> {return o1[1] - o2[1];} );
		w[strV] = 0;
		pq.offer(new int[] {strV, w[strV]});
		
		StringBuilder sb = new StringBuilder();
		
		while(!pq.isEmpty()) {
			int[] t = pq.poll();
			int vertex = t[0];
			int weight = t[1];
			
			if(v[vertex]) continue;
			v[vertex]  = true;
			w[vertex] = weight; 
			
			
			for (int[] temp : g[vertex]) {
				if(v[temp[0]] || w[temp[0]] < temp[1] + weight) continue;
				pq.offer(new int[] {temp[0], temp[1]+weight});
			}
		}
		
		for (int i = 1; i<w.length; i++) {
			if(i==strV) {
				sb.append(0);
			}
			
			else if(w[i]==2147483647) {
				sb.append("INF");
			}
			else sb.append(w[i]);
			
			sb.append("\n");
		}
		System.out.println(sb);
		
	}
}
