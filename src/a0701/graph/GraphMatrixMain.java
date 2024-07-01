package a0701.graph;

import java.io.*;
import java.util.*;

public class GraphMatrixMain {
	static int N;
	static int[][] g;
	static boolean[] v;
	
	static void bfs(int i) {
		ArrayDeque<Integer> q = new ArrayDeque<>();
		v[i] = true;
		q.offer(i);
		while(!q.isEmpty()) {
			i = q.poll();
			System.out.print((char)(i+'A')+" ");
				//for (int j = N-1; j>=0; j--) {
				for (int j = 0; j<N; j++) {
					if(g[i][j]!=0 && !v[j]) {
						v[j] = true;
						q.offer(j);
					}
				}
		}
	}
	
	static void dfs(int i) {
		v[i] = true;
		System.out.print((char)(i+'A')+" ");
		
		for (int j = N-1; j>=0; j--) {
//		for (int j = 0; j<N; j++) {
			if(g[i][j]!=0 && !v[j]) {
				dfs(j);
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/a0701/graph/input_graph"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int E = Integer.parseInt(br.readLine());
		g = new int[N][N];
		v = new boolean[N];
		for (int i = 0; i<E; i++) {
			String t = br.readLine();
			StringTokenizer st = new StringTokenizer(t);
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			g[from][to] = 1;
			g[to][from] =1;
		}
		
		//for (int[] t : g) System.out.println(Arrays.toString(t));
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
x 0 1 2 3 4 5 6
0 . 1 1 . . . .
1 1 . . 1 1 . .
2 1 . . . 1 . .
3 . 1 . . . 1 .
4 . 1 1 . . 1 . 
5 . . . 1 1 . 1
6 . . . . . 1 . 
*/