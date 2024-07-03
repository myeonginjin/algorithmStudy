package a0702.kruskal;

import java.io.*;
import java.util.*;

public class TopologicalSort {//간선이 많으면 (행렬로 하는게) 적으면 인접 리스트로 만드는 ~ // 
	static int N, M; //N은 정점의 수, M은 간선의 수
	static List<Integer>[] g; 
	static int[] indegree;
	
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("src/a0702/kruskal/input_topologicalsort.txt"));
		Scanner sc=new Scanner(System.in);
		N=sc.nextInt();
		M=sc.nextInt();
		
		g=new List[N+1]; for(int i=1; i<N+1; i++) g[i]=new ArrayList<>();
		indegree=new int[N+1];
		
		for(int i=0;i<M; i++) {
			int from=sc.nextInt();  // 일반적으로 변수명 v
			int to=sc.nextInt();  // u 를 많이 쓴다
			g[from].add(to);
			indegree[to]++;    //진입차수누적
		}
		for(List<Integer> a:g) System.out.println(a); System.out.println();
		
		bfs(); // 위상정렬은 진입이 0인거부터 해야 하니 매개변수 0 x
		sc.close();
	}
	

	static void bfs() {
		ArrayDeque<Integer> q=new ArrayDeque<>();
//		PriorityQueue<Integer> q=new PriorityQueue<>();  //정점 오름차순
		for(int i=1; i<N+1; i++) {
			if(indegree[i]==0) q.offer(i); //0인거 찾아 큐에 넣기
		}
		while(!q.isEmpty()) {
			int i=q.poll();
			System.out.print(i+" ");
			for(int j:g[i]) {
				if(--indegree[j]==0) q.offer(j);
			}
		}
	}
}