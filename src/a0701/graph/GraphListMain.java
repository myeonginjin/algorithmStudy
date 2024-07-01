package a0701.graph;

import java.io.*;
import java.util.*;

public class GraphListMain {
	static int N;
	static List<Integer>[] g;
	static boolean[] v;

//	
	static void bfs(int i) {
		ArrayDeque<Integer> q = new ArrayDeque<>();
		v[i] = true;
		q.offer(i);
		while(!q.isEmpty()) {
			i = q.poll();
			System.out.print((char)(i+'A')+" ");
				for (int j:g[i]) {
					if(!v[j]) {
						v[j] = true;
						q.offer(j);
					}
				}
		}
	}
//	
	static void dfs(int i) {
		v[i] = true;
		System.out.print((char)(i+'A')+" ");
		
		for(int j: g[i]) {
			if(!v[j]) {
				dfs(j);
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/a0701/graph/input_graph"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int E = Integer.parseInt(br.readLine());
		g = new List[N]; for (int i = 0; i<N; i++) g[i] = new ArrayList<>();
		v = new boolean[N];
		for (int i = 0; i<E; i++) {
			String t = br.readLine();
			StringTokenizer st = new StringTokenizer(t);
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			g[from].add(to);
			g[to].add(from);
		}
		
		//for (List t : g) System.out.println(t);
		
		//for (int i = 0; i<N; i++) System.out.println("" +(char)(i+'A')+i+": "+g[i]); 
		bfs(0);
		//dfs(0);
		
		br.close();
	}

}


/*bfs
 * A B C D E F G
 */



/* dfs
 * A B D F E C G    0부터 n까지
 * A C E F G D B    n-1부터 0까지



 ....A0
.../.\
..B1.C2
./.\./
D3..E4
..\.|
...F5-G6
 */


/*
0 -> 1 2
1 -> 3 4
2 -> 4
3 -> 5
4 -> 5
5 -> 6
6 ->
*/
