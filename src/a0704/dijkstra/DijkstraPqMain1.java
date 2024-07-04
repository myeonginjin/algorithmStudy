package a0704.dijkstra;

import java.io.*;
import java.util.*;

public class DijkstraPqMain1 {
		public static void main(String[] args) throws Exception{
			System.setIn(new FileInputStream("src/a0704/dijkstra/input_dijkstra"));
			Scanner sc=new Scanner(System.in);
			int N= sc.nextInt();		
			List<int[]>[] g=new List[N]; for(int i=0; i<N; i++) g[i]=new ArrayList<>();
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					int c=sc.nextInt();
					if(c!=0) g[i].add(new int[] {j,c});
					
				}							
			}
			
			boolean[] v=new boolean[N];
			int[] dist=new int[N]; 
			for(int i=0; i<N; i++) dist[i]=Integer.MAX_VALUE/2;  
			
			PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2)->Integer.compare(o1[1], o2[1]));
			dist[0]=0;
			pq.offer(new int[] {0,dist[0]}); //정점, 비용
			System.out.println(Arrays.toString(dist)); System.out.println();
			while(!pq.isEmpty()) {
				int[] vc = pq.poll();
				int min = vc[1];
				int minVertex = vc[0];
				if(v[minVertex]) continue;
				
				v[minVertex]=true;
				System.out.println(Arrays.toString(v));
				System.out.println("minVertex="+minVertex+" min="+min);
				if(minVertex++==N-1) break;		
			
				for(int[] j:g[minVertex]) {
					if(!v[j[0]] && dist[j[0]]>min+j[1]) {
								   dist[j[0]]=min+j[1]; 
								   pq.offer(new int[] {j[0], dist[j[0]]});
					}
				}
				System.out.println(Arrays.toString(dist)); System.out.println("=================");
			
			}
			System.out.println(dist[N-1]);
			sc.close();
		}
	}