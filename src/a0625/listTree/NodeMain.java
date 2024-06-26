package a0625.listTree;

import java.io.FileInputStream;
import java.util.Scanner;


//애드 퍼스트 하는이유? 언제 연결지은 곳에 끝까지 찾아가서 이어 붙여
//걍 맨앞에 놓고 링크만 연결해주면되지 원래 첫번째엿던애를 링크로 이어주면 되지 


public class NodeMain {
	static class Node {
		int vertex;
		Node link;
		
		Node (int vertex, Node link) {
			this.vertex = vertex;
			this.link = link;
		}
		@Override
		public String toString() {
			return "" + (char)(vertex + 'A') + vertex + " -> " + link;
		}
		
		
	}
	static int N;
	static Node[] g;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_graph"));
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int E = sc.nextInt();
		g = new Node[N];
		for (int i = 0; i < E; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			g[from] = new Node(to, g[from]);
			g[to] = new Node(from, g[to]);
		}
		
		for (int i = 0; i < N; i++) {
			System.out.print("" + (char)(i + 'A') + i + " : ");
			for (Node j = g[i]; j != null; j = j.link) {
				System.out.print("" + (char)(j.vertex + 'A') + j.vertex + " -> ");
			}
			System.out.println("null");
		}
		System.out.println();
		
//		for (Node a : g) System.out.println(a); System.out.println();
//		for (int i = 0; i < N; i++) System.out.println("" + (char)(i + 'A') + i + " : " + g[i]);
		
		sc.close();
	}
}




/*

....A0                     
.../.\
..B1.C2
./.\./
D3..E4
..\.|
...F5-G6

정점7개 간선8개 
아래와 같이 연결되어 있음
8
7
0 1
0 2
1 3
1 4
2 4
3 5
4 5
5 6



*/