package a0701.graph;

import java.io.*;
import java.util.*;

public class GraphNodeMain {
	
	static class Node {
		int vertex;
		Node link;
		Node(int vertex, Node link) {
			this.vertex = vertex;
			this.link = link;
		}
		@Override
		public String toString() {
			
			return (char)(vertex+'A')+"->"+link;
		}
	}
	
	
	static int N;
	static Node[] g;
	static boolean[] v;


	static void bfs(int i) {
		ArrayDeque<Integer> q = new ArrayDeque<>();
		v[i] = true;
		q.offer(i);
		while(!q.isEmpty()) {
			i = q.poll();
			System.out.print((char)(i+'A')+" ");
				for (Node j = g[i]; j!=null; j=j.link) { //0->N
					if(!v[j.vertex]) {
						v[j.vertex] = true;
						q.offer(j.vertex);
					}
				}
		}
	}

	static void dfs(int i) {
		v[i] = true;
		System.out.print((char)(i+'A')+" ");
		
		for(Node j = g[i]; j!=null;  j= j.link) { // N->0
			if(!v[j.vertex]) {
				dfs(j.vertex);
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/a0701/graph/input_graph"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int E = Integer.parseInt(br.readLine());
		g = new Node[N];
		v = new boolean[N];
		for (int i = 0; i<E; i++) {
			String t = br.readLine();
			StringTokenizer st = new StringTokenizer(t);
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			g[from] = new Node(to,g[from]);
			g[to] = new Node(from, g[to]);
		}
		
		//for (Node a : g) System.out.println(a); 
		
		//for (int i = 0; i<N; i++) System.out.println("" +(char)(i+'A')+i+": "+g[i]); 
		bfs(0);
		//dfs(0);
		
		br.close();
	}
	


}


/*bfs
 * A B C D E F G    0->N
 * A C B E D F G    N->0
 */
	


/* dfs
 * A B D F E C G    0부터 n까지
 * A C E F G D B    n-1부터 0까지


 <> 왜 addFrist해? 연결된 노드가 많아지면 삽입 연산이 느려져. 맨 앞에 넣어버리는게 훨씬 빠르니까
 A0 -> 2 -> 1 -> null
 B1 -> 4 -> 3 -> 0 -> null
 C2 -> 4 -> 0 -> null
 D3 -> 5 -> 1 -> null
 E4 -> 5 -> 2 -> 1 -> null
 F5 -> 6 -> 4 -> 3 -> null
 G6 -> 5 -> null


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
