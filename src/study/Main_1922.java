package study;


import java.util.*;
import java.io.*;

public class Main_1922 {
	static int[] v;
	
	static boolean union(int v1, int v2) {
		int v1R = find(v1);
		int v2R = find(v2);
		
		if(v1R == v2R) return false;
		
		v[v1R] = v2R;
		
		return true;
	}
	
	static int find(int vertex) {
		if(v[vertex] == vertex) return vertex;
		
		return v[vertex] = find(v[vertex]);
	}
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/study/input_1922"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		
		String str;
		StringTokenizer st;
		
		int[][] g = new int[m][3];
		v = new int[n+1]; for (int i = 1; i<=n; i++) v[i] = i;
		
		for (int i = 0; i<m; i++) {
			str = br.readLine();
			st = new StringTokenizer(str);
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int dis = Integer.parseInt(st.nextToken());
			g[i][0] = from;
			g[i][1] = to;
			g[i][2] = dis;
		}
		
		Arrays.sort(g, (o1,o2) -> { return o1[2] - o2[2]; } );
		
		int sum = 0, cnt = 0; 
		for (int i = 0; i<m; i++) {
			if(cnt == n-1) break;
			int v1 = g[i][0];
			int v2 = g[i][1];
			int dis = g[i][2];
			
			
			if(!union(v1,v2)) continue;
			
			sum += dis;
			cnt++;
		}
		
		System.out.println(sum);
	}

}
